import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Pokemon {
    public void Pokemon(){
        Scanner pokemonObject = new Scanner(System.in);
        System.out.println("Please enter a Pokemon's name");
        String pokemon = pokemonObject.nextLine();
        SearchPokemon(pokemon);
    }
    private static void SearchPokemon(String pokemon){
        try {
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/squirtle/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod(("GET"));

            if (conn.getResponseCode() != 200){
                throw new RuntimeException("Failed: HTTP error code 200 " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()
            ));
            String output;
            System.out.println("Output from server ... \n");
            while ((output = br.readLine()) != null) {

                System.out.println(output);
            }

            // Need to try and set up the json reader here to store items into the PokemonDetails object...
            conn.disconnect();
        } catch (MalformedURLException exc){
            exc.printStackTrace();
        } catch (IOException exc){
            exc.printStackTrace();
        }
    }
}
