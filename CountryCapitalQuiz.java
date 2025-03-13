import java.util.*;

class Quiz<C, K> {
    private Map<C, K> quizData;

    public Quiz() {
        this.quizData = new HashMap<>();
    }

    public void addCountriesAndCapitals(C country, K capital) {
        quizData.put(country, capital);
    }

    public K getAnswer(C country) {
        return quizData.get(country);
    }

    public Set<C> getCountries() {
        return quizData.keySet();
    }
}

public class CountryCapitalQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Quiz<String, String> countryQuiz = new Quiz<>();

        countryQuiz.addCountriesAndCapitals("United States of America", "Washington, D.C.");
        countryQuiz.addCountriesAndCapitals("United Kingdom", "London");
        countryQuiz.addCountriesAndCapitals("Mexico", "Mexico City");
        countryQuiz.addCountriesAndCapitals("Brazil", "Brasilia");
        countryQuiz.addCountriesAndCapitals("Canada", "Ottawa");
        countryQuiz.addCountriesAndCapitals("Italy", "Rome");
        countryQuiz.addCountriesAndCapitals("France", "Paris");
        countryQuiz.addCountriesAndCapitals("Spain", "Madrid");
        countryQuiz.addCountriesAndCapitals("Germany", "Berlin");
        countryQuiz.addCountriesAndCapitals("Russia", "Moscow");
        countryQuiz.addCountriesAndCapitals("China", "Beijing");
        countryQuiz.addCountriesAndCapitals("Japan", "Tokyo");
        countryQuiz.addCountriesAndCapitals("South Korea", "Seoul");
        countryQuiz.addCountriesAndCapitals("Thailand", "Bangkok");
        countryQuiz.addCountriesAndCapitals("Australia", "Canberra");
        countryQuiz.addCountriesAndCapitals("South Africa", "Pretoria");
        countryQuiz.addCountriesAndCapitals("India", "New Delhi");

        System.out.println("Welcome to the Country-Capital Quiz!");
        System.out.println("Enter in the correct capital of the prompted country.");
        System.out.println("There are a total of: " + countryQuiz.getCountries().size() + " questions.");
        System.out.println("You will only have one chance to answer!");
        System.out.println("When ready press enter to start...");
        sc.nextLine();

        List<String> countries = new ArrayList<>(countryQuiz.getCountries());
        Collections.shuffle(countries);

        int score = 0;
        for (String country : countries) {
            System.out.print("What is the capital of " + country + "? ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase(countryQuiz.getAnswer(country))) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + countryQuiz.getAnswer(country) + "\n");
            }
        }
        
        System.out.println("End of Quiz! Your score is: " + score + "/" + countries.size());
        sc.close();
    }
}
