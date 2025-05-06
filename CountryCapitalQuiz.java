
import java.util.*;

class Quiz<C, K> {
    private Map<C, K> quizData;

    public Quiz() {
        this.quizData = new HashMap<>();
    }

    public void add(C country, K capital) {
        quizData.put(country, capital);
    }

    public K getAnswer(C country) {
        return quizData.get(country);
    }

    public Set<C> getCountries() {
        return quizData.keySet();
    }

    public int size() {
        return quizData.size();
    }
}

public class CountryCapitalQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Quiz<String, String> quiz = new Quiz<>();

        System.out.println("Select a region to be quizzed on:");
        System.out.println("1. North and Central America");
        System.out.println("2. South America");
        System.out.println("3. Europe");
        System.out.println("4. Africa");
        System.out.println("5. Asia");
        System.out.println("6. Oceania");
        System.out.println("7. The World");
        System.out.print("Enter your choice (1-7): ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1 -> CountryLoaders.loadNorthAndCentralAmerica(quiz);
            case 2 -> CountryLoaders.loadSouthAmerica(quiz);
            case 3 -> CountryLoaders.loadEurope(quiz);
            case 4 -> CountryLoaders.loadAfrica(quiz);
            case 5 -> CountryLoaders.loadAsia(quiz);
            case 6 -> CountryLoaders.loadOceania(quiz);
            case 7 -> CountryLoaders.loadWorld(quiz);
            default -> {
                System.out.println("Invalid choice. Defaulting to World.");
                CountryLoaders.loadWorld(quiz);
            }
        }

        if (quiz.size() == 0) {
            System.out.println("No countries available in this region.");
            return;
        }

        System.out.println("There are " + quiz.size() + " countries in this region.");
        int numQuestions;

        while (true) {
            System.out.print("How many questions would you like to answer? ");
            if (sc.hasNextInt()) {
                numQuestions = sc.nextInt();
                sc.nextLine(); 
                if (numQuestions > 0 && numQuestions <= quiz.size()) {
                    break;
                } else {
                    System.out.println("Please enter a number between 1 and " + quiz.size() + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
            }
        }

        System.out.println("You will only have one chance to answer each question!");
        System.out.println("When ready, press Enter to start...");
        sc.nextLine();

        List<String> countries = new ArrayList<>(quiz.getCountries());
        Collections.shuffle(countries);
        List<String> selected = countries.subList(0, numQuestions);

        int score = 0;
        for (String country : selected) {
            System.out.print("What is the capital of " + country + "? ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase(quiz.getAnswer(country))) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + quiz.getAnswer(country) + "\n");
            }
        }

        System.out.println("End of Quiz! Your score is: " + score + "/" + numQuestions);
        sc.close();
    }
}
