package edu.cnm.deepdive.green_print.controller;


import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import edu.cnm.deepdive.green_print.service.CC_APIWebService.GetCCAPITask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CC_API {

    private static String[] keys = {
            "input_location",                               // User inputs their zip code
            "input_size",                                   // The number of people that live in the user's house
            "input_footprint_household_adults",             // How many adults occupy the user's house
            "input_footprint_household_children",           // How many children occupy the user's house
            "input_income",                                 // User inputs their income (dollar amount gets converted to an Int between 1-11)
            "input_footprint_housing_squarefeet",           // How large is the user's house
            "input_footprint_housing_electricity_dollars",
            "input_footprint_housing_naturalgas_dollars",
            "input_footprint_housing_heatingoil_dollars",
            "input_footprint_housing_watersewage",
            "input_footprint_housing_hdd",                  // Days that the house is heated/year
            "input_footprint_housing_cdd",                  // Days that the house is cooled/year
            "input_footprint_transportation_miles1",
            "input_footprint_transportation_mpg1",
            "input_footprint_transportation_miles2",
            "input_footprint_transportation_mpg2",
            "input_footprint_transportation_miles3",
            "input_footprint_transportation_mpg3",
            "input_footprint_transportation_airtotal",
            "input_footprint_transportation_publictrans"
    };

    // Set to default values
    private static String[] requiredKeys = {
            "input_location_mode=1",                                        // 1 = Zip code
            "input_changed=0",                                              // Meaningless variable
            "input_footprint_transportation_num_vehicles=3",                // Number of vehicles is assumed to be 3, if 0mpg is input then that car gets deleted
            "input_footprint_transportation_fuel1=1",
            "input_footprint_transportation_fuel2=1",
            "input_footprint_transportation_fuel3=1",
            "input_footprint_transportation_miles4=0",
            "input_footprint_transportation_mpg4=0",
            "input_footprint_transportation_fuel4=1",
            "input_footprint_transportation_miles5=0",
            "input_footprint_transportation_mpg5=0",
            "input_footprint_transportation_fuel5=1",
            "input_footprint_transportation_miles6=0",
            "input_footprint_transportation_mpg6=0",
            "input_footprint_transportation_fuel6=1",
            "input_footprint_transportation_miles7=0",
            "input_footprint_transportation_mpg7=0",
            "input_footprint_transportation_fuel7=1",
            "input_footprint_transportation_miles8=0",
            "input_footprint_transportation_mpg8=0",
            "input_footprint_transportation_fuel8=1",
            "input_footprint_transportation_miles9=0",
            "input_footprint_transportation_mpg9=0",
            "input_footprint_transportation_fuel9=1",
            "input_footprint_transportation_miles10=0",
            "input_footprint_transportation_mpg10=0",
            "input_footprint_transportation_fuel10=1",
            "input_footprint_transportation_airtype=simple",                // Just total miles covered for air
            "input_footprint_transportation_groundtype=simple",             // Just total miles ridden for public transportation
            "input_footprint_housing_electricity_type=0",                   // In $/year
            "input_footprint_housing_cleanpercent=0",                       // Assume no clean energy
            "input_footprint_housing_naturalgas_type=0",                    // In $/year
            "input_footprint_housing_heatingoil_type=0",                    // In $/year
            "input_footprint_housing_heatingoil_dollars_per_gallon=4",      // On average, heating oil is $4/gallon
            "input_footprint_shopping_food_meattype=simple",                // Simple description of meat consumed by the user
            "input_footprint_shopping_food_meatfisheggs=0",                 // Calories eaten daily of meat, fish and eggs
            "input_footprint_shopping_food_dairy=0",                        // Calories eaten daily of dairy
            "input_footprint_shopping_food_otherfood=0",                    // Calories per day other food
            "input_footprint_shopping_food_fruitvegetables=0",              // Calories per day fruits and veggies
            "input_footprint_shopping_food_cereals=0",                      // Calories per day cereals
            "input_footprint_shopping_goods_default_furnitureappliances=0", // Furniture and appliances cost/year
            "input_footprint_shopping_goods_default_clothing=0",            // Clothing cost/year
            "input_footprint_shopping_goods_default_other_entertainment=0", // Entertainment cost/year
            "input_footprint_shopping_goods_default_other_office=0",        // Office supplies cost/year
            "input_footprint_shopping_goods_default_other_personalcare=0",  // Personal care cost/year
            "input_footprint_shopping_goods_default_other_autoparts=0",     // Auto cost/year
            "input_footprint_shopping_goods_default_other_medical=0",
            "input_footprint_shopping_goods_type=advanced",
            "input_footprint_shopping_goods_total=0",                       // No input by the user, sum of the subtotals
            "input_footprint_shopping_services_type=simple",
            "input_footprint_shopping_services_total=0",                    // How much the user spends on services per year
            "input_footprint_housing_gco2_per_kwh=1000"                     // Grams of CO2 released per KWh of electricity, 1000 is average
    };


    public float calculateFootprint(Integer[] inputValues){

        // Example curl request
        // curl -X GET "https://apis.berkeley.edu/coolclimate/footprint-sandbox?input_location_mode=1&input_location=87113&input_income=3&input_size=2&input_footprint_transportation_miles1=10000&input_footprint_transportation_mpg1=12&input_footprint_transportation_fuel1=0" -H "accept: application/xml" -H "app_id: d6f58a93" -H "app_key: 0a16fb60fa68e7fdd7551231dd01a736"

        //try {
//            String url = "https://apis.berkeley.edu/coolclimate/footprint";
//            String format = "xml";
//            String app_id = "d6f58a93";
//            String app_key = "0a16fb60fa68e7fdd7551231dd01a736";

            //StringBuilder params = new StringBuilder();
        Map<String, String> params = new HashMap<>();
            // Build Parameter request string
            for (int i = 0; i < inputValues.length; i++) {

                int curValue = inputValues[i];

//                if(i > 0) {
//                    params.append("&");
//                }

                params.put(keys[i], String.valueOf(curValue));
            }


            // Add required keys
            // Get two letter state abbreviation from zip code
            String stateAbbrvStr = getStateFromZip(String.valueOf(inputValues[0]));
            System.out.printf("State: %s%n", stateAbbrvStr);
            params.put("internal_state_abbreviation=", stateAbbrvStr);

            // Add required keys with no value
            for (int i = 0; i < requiredKeys.length; i++) {
                params.put( requiredKeys[i], "");
            }


            // Build full url string
            // fullUrlStr = url + "?" + params.toString();
           // System.out.printf("API Request: %s%n", fullUrlStr);



//            // Send URL get request
//            URL obj = new URL(fullUrlStr);
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//            con.setRequestProperty("accept", "application/" + format);
//            con.setRequestProperty("app_id", app_id);
//            con.setRequestProperty("app_key", app_key);
//
//            con.setRequestMethod("GET");
//
//            int responseCode = con.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//
//            in.close();
                new GetCCAPITask().

           // String responseStr = response.toString();
            //System.out.print(responseStr);


            // Parse XML response to get value for carbon footprint grand total
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new InputSource(new StringReader(responseStr)));

            NodeList responseList = doc.getElementsByTagName("response");
            if (responseList.getLength() > 0) {
                Element allElements = (Element)responseList.item(0);

                String totalTonsPerYearStr = getValueForKey(allElements, "result_grand_total");

                // Example: You can get any value from a key in the response
                //String otherValueFromResponse = getValueForKey(allElements, "result_takeaction_grand_total");
                //System.out.printf("Example of Other Response Value: %s%n", otherValueFromResponse);

                if (totalTonsPerYearStr.isEmpty()) {
                    return -1;
                } else {
                    return Float.parseFloat(totalTonsPerYearStr);
                }

            } else {
                // Error
                return -1;
            }

//        } catch (Exception e) {
//            System.out.println(e);
//            return -1;
//        }
    }

    private String getValueForKey(Element allElements, String keyStr) {

        String valueStr = "";

        try {
            valueStr = allElements.getElementsByTagName(keyStr).item(0).getTextContent();
        }
        catch (Exception e) {
            String errorMsg =  allElements.getElementsByTagName("error_message").item(0).getTextContent();
            System.out.printf("%n*** API Request Error: %s ***%n", errorMsg);
        }

        return valueStr;
    }

    private String getStateFromZip(String zipCodeStr) {

        // Source URL
        // https://stackoverflow.com/questions/28821804/how-can-i-quickly-determine-the-state-for-a-given-zipcode

        // Ensure you don"t parse codes that start with 0 as octal values
        int zipCodeInt = Integer.parseInt(zipCodeStr,10);

        String stateStr = "";

        // Code blocks alphabetized by state
        if (zipCodeInt >= 35000 && zipCodeInt <= 36999) {
            stateStr = "AL";
        }
        else if (zipCodeInt >= 99500 && zipCodeInt <= 99999) {
            stateStr = "AK";
        }
        else if (zipCodeInt >= 85000 && zipCodeInt <= 86999) {
            stateStr = "AZ";
        }
        else if (zipCodeInt >= 71600 && zipCodeInt <= 72999) {
            stateStr = "AR";
        }
        else if (zipCodeInt >= 90000 && zipCodeInt <= 96699) {
            stateStr = "CA";
        }
        else if (zipCodeInt >= 80000 && zipCodeInt <= 81999) {
            stateStr = "CO";
        }
        else if (zipCodeInt >= 6000 && zipCodeInt <= 6999) {
            stateStr = "CT";
        }
        else if (zipCodeInt >= 19700 && zipCodeInt <= 19999) {
            stateStr = "DE";
        }
        else if (zipCodeInt >= 32000 && zipCodeInt <= 34999) {
            stateStr = "FL";
        }
        else if (zipCodeInt >= 30000 && zipCodeInt <= 31999) {
            stateStr = "GA";
        }
        else if (zipCodeInt >= 96700 && zipCodeInt <= 96999) {
            stateStr = "HI";
        }
        else if (zipCodeInt >= 83200 && zipCodeInt <= 83999) {
            stateStr = "ID";
        }
        else if (zipCodeInt >= 60000 && zipCodeInt <= 62999) {
            stateStr = "IL";
        }
        else if (zipCodeInt >= 46000 && zipCodeInt <= 47999) {
            stateStr = "IN";
        }
        else if (zipCodeInt >= 50000 && zipCodeInt <= 52999) {
            stateStr = "IA";
        }
        else if (zipCodeInt >= 66000 && zipCodeInt <= 67999) {
            stateStr = "KS";
        }
        else if (zipCodeInt >= 40000 && zipCodeInt <= 42999) {
            stateStr = "KY";
        }
        else if (zipCodeInt >= 70000 && zipCodeInt <= 71599) {
            stateStr = "LA";
        }
        else if (zipCodeInt >= 3900 && zipCodeInt <= 4999) {
            stateStr = "ME";
        }
        else if (zipCodeInt >= 20600 && zipCodeInt <= 21999) {
            stateStr = "MD";
        }
        else if (zipCodeInt >= 1000 && zipCodeInt <= 2799) {
            stateStr = "MA";
        }
        else if (zipCodeInt >= 48000 && zipCodeInt <= 49999) {
            stateStr = "MI";
        }
        else if (zipCodeInt >= 55000 && zipCodeInt <= 56999) {
            stateStr = "MN";
        }
        else if (zipCodeInt >= 38600 && zipCodeInt <= 39999) {
            stateStr = "MS";
        }
        else if (zipCodeInt >= 63000 && zipCodeInt <= 65999) {
            stateStr = "MO";
        }
        else if (zipCodeInt >= 59000 && zipCodeInt <= 59999) {
            stateStr = "MT";
        }
        else if (zipCodeInt >= 27000 && zipCodeInt <= 28999) {
            stateStr = "NC";
        }
        else if (zipCodeInt >= 58000 && zipCodeInt <= 58999) {
            stateStr = "ND";
        }
        else if (zipCodeInt >= 68000 && zipCodeInt <= 69999) {
            stateStr = "NE";
        }
        else if (zipCodeInt >= 88900 && zipCodeInt <= 89999) {
            stateStr = "NV";
        }
        else if (zipCodeInt >= 3000 && zipCodeInt <= 3899) {
            stateStr = "NH";
        }
        else if (zipCodeInt >= 7000 && zipCodeInt <= 8999) {
            stateStr = "NJ";
        }
        else if (zipCodeInt >= 87000 && zipCodeInt <= 88499) {
            stateStr = "NM";
        }
        else if (zipCodeInt >= 10000 && zipCodeInt <= 14999) {
            stateStr = "NY";
        }
        else if (zipCodeInt >= 43000 && zipCodeInt <= 45999) {
            stateStr = "OH";
        }
        else if (zipCodeInt >= 73000 && zipCodeInt <= 74999) {
            stateStr = "OK";
        }
        else if (zipCodeInt >= 97000 && zipCodeInt <= 97999) {
            stateStr = "OR";
        }
        else if (zipCodeInt >= 15000 && zipCodeInt <= 19699) {
            stateStr = "PA";
        }
        else if (zipCodeInt >= 300 && zipCodeInt <= 999) {
            stateStr = "PR";
        }
        else if (zipCodeInt >= 2800 && zipCodeInt <= 2999) {
            stateStr = "RI";
        }
        else if (zipCodeInt >= 29000 && zipCodeInt <= 29999) {
            stateStr = "SC";
        }
        else if (zipCodeInt >= 57000 && zipCodeInt <= 57999) {
            stateStr = "SD";
        }
        else if (zipCodeInt >= 37000 && zipCodeInt <= 38599) {
            stateStr = "TN";
        }
        else if ( (zipCodeInt >= 75000 && zipCodeInt <= 79999) || (zipCodeInt >= 88500 && zipCodeInt <= 88599) ) {
            stateStr = "TX";
        }
        else if (zipCodeInt >= 84000 && zipCodeInt <= 84999) {
            stateStr = "UT";
        }
        else if (zipCodeInt >= 5000 && zipCodeInt <= 5999) {
            stateStr = "VT";
        }
        else if (zipCodeInt >= 22000 && zipCodeInt <= 24699) {
            stateStr = "VA";
        }
        else if (zipCodeInt >= 20000 && zipCodeInt <= 20599) {
            stateStr = "DC";
        }
        else if (zipCodeInt >= 98000 && zipCodeInt <= 99499) {
            stateStr = "WA";
        }
        else if (zipCodeInt >= 24700 && zipCodeInt <= 26999) {
            stateStr = "WV";
        }
        else if (zipCodeInt >= 53000 && zipCodeInt <= 54999) {
            stateStr = "WI";
        }
        else if (zipCodeInt >= 82000 && zipCodeInt <= 83199) {
            stateStr = "WY";
        }
        else {
            stateStr = "ER";
        }
        return stateStr;
    }
}
