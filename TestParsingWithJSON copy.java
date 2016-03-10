/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Renad khateeb
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
//import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class TestParsingWithJSON {

    private static JSONTokener jsonOut;
    private static JSONTokener jsonPOut;

    public static void main(String myHelpers[]) throws JSONException, IOException {
                       
                File f = new File("/Users/admin/Dropbox/SocialNetwork/src/java/relation.json");

                  File f2 = new File("/Users/admin/Dropbox/SocialNetwork/src/java/people2.json"); 
                  
                
                    String jsonString = readFile(f.getPath());
                    String jsonSP = readFile(f2.getPath());
                               
                    jsonOut = new JSONTokener(jsonString);
                    jsonPOut = new JSONTokener(jsonSP);
                    JSONObject output = new JSONObject(jsonOut);
                    JSONObject peopleOutput = new JSONObject(jsonPOut);
                    
                //    int nbThreads = output.getJSONObject("set-up").getInt("nbThreads");
                // array use1 index0 
                
                    
                    JSONObject docs = output.getJSONObject("relations");
                    JSONObject docs1 = peopleOutput.getJSONObject("network");

                    JSONArray array = docs.getJSONArray("relation");
                    JSONArray array1 = docs1.getJSONArray("user");
                    
//                    for( int i=0;i<array1.length();i++){
//                        System.out.println("firstname   " + array1.getJSONObject(i).getString("firstname"));
//                        System.out.println("lastname    "+array1.getJSONObject(i).getString("lastname"));
//                        System.out.println("-ID    "+array1.getJSONObject(i).getString("-ID"));
//                        System.out.println("Gender    "+array1.getJSONObject(i).getString("Gender"));
//                        System.out.println("birthdate    "+array1.getJSONObject(i).getString("birthdate"));
//                        System.out.println("address   "+array1.getJSONObject(i).getString("address"));
//                        System.out.println("hobbies   "+array1.getJSONObject(i).getString("hobbies"));
//                        System.out.println("nationality    "+array1.getJSONObject(i).getString("nationality"));
//                        System.out.println("");
//                    }
                    
                    
                    
                   
                        for(int j =0;j<array1.length();j++){
                            
                            String personId = array1.getJSONObject(j).getString("-ID");
//                            if(personId.equals(r)){
                            String firstName = array1.getJSONObject(j).getString("firstname");
                            String lastName = array1.getJSONObject(j).getString("lastname");
                            String Gender = array1.getJSONObject(j).getString("Gender");
                            String birthDate = array1.getJSONObject(j).getString("birthdate");
                            String address = array1.getJSONObject(j).getString("address");
                            String hobbies = array1.getJSONObject(j).getString("hobbies");
                            String nationality = array1.getJSONObject(j).getString("nationality");
                           
                            System.out.println("First Name:  " +firstName );
                            System.out.println("Last Name:  " + lastName );
                            System.out.println("ID:  " +personId );
                             System.out.println("Gender:  "+ Gender);
                              System.out.println("Birth-Date:  " + birthDate );
                               System.out.println("Address:  " + address);
                                System.out.println("Hobbies:  " + hobbies);
                                 System.out.println("Nationality:  " + nationality);
                              
                             for(int i =0 ; i<array.length() ;i++){
                        String r = array.getJSONObject(i).getString("person_id");
                        if(r.equals(personId)){
                       String friend = array.getJSONObject(i).getString("friend_id");
                        for(int k=0;k<array1.length();k++){
                            String friendId = array1.getJSONObject(k).getString("-ID");
                            if(friendId.equals(friend)){
                                System.out.println("Friend Name :   " + array1.getJSONObject(k).getString("firstname") + " " + array1.getJSONObject(k).getString("lastname") );
                            break;
                            }
                        }
                    
                        }
                    }System.out.println("-----------------------------------");
                            
                            }
                        
//                         System.out.println("person_id "+array.getJSONObject(i).getString("person_id"));
//                         System.out.println("person_id "+array.getJSONObject(i).getString("person_id"));
//                    }
//                   System.out.println("friend_id "+array.getJSONObject(i).getString("friend_id"));
//                  
//                    }
                  
                   
                   
                   
                   
                         
            
        
            }
    

    private static String readFile(String file) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
            
            
        }
          reader.close();
        return stringBuilder.toString();
    }

}
