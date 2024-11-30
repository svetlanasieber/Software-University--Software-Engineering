package ExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static <KeyValuePair> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     
        Map<String, String> piecesCompositors = new LinkedHashMap<>();

      
        Map<String, String> piecesKeys = new LinkedHashMap<>();

       
        int countPieces = Integer.parseInt(scanner.nextLine()); 

        for (int count = 1; count <= countPieces; count++) {
            String pieceData = scanner.nextLine(); 
            String[] pieceParts = pieceData.split("\\|"); 

            String pieceName = pieceParts[0]; 
            String pieceComposer = pieceParts[1]; 
            String pieceKey = pieceParts[2]; 

          
            piecesCompositors.put(pieceName, pieceComposer);
            piecesKeys.put(pieceName, pieceKey);

        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] commandParts = command.split("\\|");
            String commandName = commandParts[0]; 
            String pieceName = commandParts[1];

          
            if (commandName.equals("Add")) {
           
                String pieceComposer = commandParts[2];
                String pieceKey = commandParts[3];
            
                if (piecesCompositors.containsKey(pieceName) && piecesKeys.containsKey(pieceName)) {
                  
                    System.out.printf("%s is already in the collection!%n", pieceName);
                } else {
                   
                    piecesCompositors.put(pieceName, pieceComposer);
                    piecesKeys.put(pieceName, pieceKey);
                    System.out.printf("%s by %s in %s added to the collection!%n", pieceName, pieceComposer, pieceKey);
                }
            } else if (commandName.equals("Remove")) {
             
                if (piecesCompositors.containsKey(pieceName) && piecesKeys.containsKey(pieceName)) {
                 
                    piecesCompositors.remove(pieceName);
                    piecesKeys.remove(pieceName);
                    System.out.printf("Successfully removed %s!%n", pieceName);
                } else {
                  
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                }
            } else if (commandName.equals("ChangeKey")) {
              
                String newKey = commandParts[2]; 
            
                if (piecesCompositors.containsKey(pieceName) && piecesKeys.containsKey(pieceName)) {
                
                    piecesKeys.put(pieceName, newKey);
                    System.out.printf("Changed the key of %s to %s!%n", pieceName, newKey);
                } else {
                    
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                }
            }
            command = scanner.nextLine();
        }

     
        for (Map.Entry<String, String> entry : piecesCompositors.entrySet()) {
       
            String piece = entry.getKey();
            String compositor = entry.getValue();
            String pieceKey = piecesKeys.get(piece);
            System.out.printf("%s -> Composer: %s, Key: %s%n", piece, compositor, pieceKey);
        }

    

    }
}
