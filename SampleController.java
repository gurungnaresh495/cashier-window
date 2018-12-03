package application;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class SampleController implements Initializable {
	@FXML
    private Button buttonAngelCake;

    @FXML
    private Button buttonCarrotCake;

    @FXML
    private Button buttonChiffonCake;

    @FXML
    private AnchorPane anchorpane2;

    @FXML
    private Label labelTop;

    @FXML
    private Label labelItems;

    @FXML
    private Label labelTotal;
    
    @FXML
    private TextField angelText;

    @FXML
    private TextField carrotText;

    @FXML
    private TextField chiffonText;
    
    @FXML
    private Button removeAngelButton;

    @FXML
    private Button removeCarrotButton;

    @FXML
    private Button removeChiffonButton;

    @FXML
    private TextField removeAngelText;

    @FXML
    private TextField removeChiffonText;

    @FXML
    private TextField removeCarrotText;
    
    @FXML
    private Button buttonPay;
    
    //private variables
    private static int angelQuantity = 0;
    private static int carrotQuantity = 0;
    private static int chiffonQuantity = 0;
    
    private static int tempAngel =0;
    private static int tempCarrot =0;
    private static int tempChiffon =0;
    private static String textToBeDisplayed = "";
    private static double tax = 0.0;
     
    
    @FXML
    void addAngelCake() {
    	tempAngel = Integer.valueOf(angelText.getText());
    	textToBeDisplayed += "Angel Cake x " + tempAngel + "		$"+ tempAngel * 12 +"\n"; 
    	labelItems.setText(textToBeDisplayed);
    	angelQuantity += tempAngel;
    	labelTotal.setText(updateTotal());
    }

    @FXML
    void addCarrotCake() {
    	tempCarrot = Integer.valueOf(carrotText.getText());
    	textToBeDisplayed += "Carrot Cake x " +	tempCarrot +"		$" + tempCarrot * 15 +"\n"; 
    	labelItems.setText(textToBeDisplayed);
    	carrotQuantity += tempCarrot;
    	labelTotal.setText(updateTotal());
    }

    @FXML
    void addChiffonCake() {
    	tempChiffon = Integer.valueOf(chiffonText.getText());
    	textToBeDisplayed += "Chiffon Cake x " + tempChiffon + " 		$" + tempChiffon *10 +"\n"; 
    	labelItems.setText(textToBeDisplayed);
    	chiffonQuantity += tempChiffon;
    	labelTotal.setText(updateTotal());
    }
    
    @FXML
    void removeAngelCake() {
    	tempAngel = Integer.valueOf(removeAngelText.getText());
    	textToBeDisplayed += "Removed Angel Cake x " + tempAngel + "		$"+ tempAngel * 12 +"\n"; 
    	labelItems.setText(textToBeDisplayed);
    	angelQuantity -= tempAngel;
    	if(angelQuantity < 0)
    	{
    		angelQuantity = 0;
    	}
    	labelTotal.setText(updateTotal());
    }

    @FXML
    void removeCarrotCake() {
    	try {
			tempCarrot = Integer.valueOf(removeCarrotText.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	textToBeDisplayed += "Removed Carrot Cake x " +	tempCarrot +"$		" + tempCarrot * 15 +"\n"; 
    	labelItems.setText(textToBeDisplayed);
    	carrotQuantity -= tempCarrot;
    	if (carrotQuantity < 0)
    	{
    		carrotQuantity = 0;
    	}
    	labelTotal.setText(updateTotal());

    }

    @FXML
    void removeChiffonCake() {

    	try {
			tempChiffon = Integer.valueOf(removeChiffonText.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			tempChiffon = 1;
		}
    	textToBeDisplayed += "Chiffon Cake x " + tempChiffon + " 		$" + tempChiffon *10 +"\n"; 
    	labelItems.setText(textToBeDisplayed);
    	chiffonQuantity -= tempChiffon;
    	if (chiffonQuantity < 0)
    	{
    		chiffonQuantity = 0;
    	}
    	labelTotal.setText(updateTotal());
    }

    
    @FXML
    void clearCart()
    {
    	angelQuantity = 0;
    	carrotQuantity = 0;
    	chiffonQuantity= 0;
    	tax = 0;
    	textToBeDisplayed = "";
    	labelTotal.setText("");
    	labelItems.setText("Cart Empty!");
    }
    
    public static String updateTotal()
    {	double total = angelQuantity * 12 + carrotQuantity * 15 + chiffonQuantity * 10;
    	tax = total * 0.08;
    	return "Angel cake x " + angelQuantity + 
    			"\nCarrot cake x " + carrotQuantity +
    			"\nChiffon Quantity x " + chiffonQuantity
    			+ "\nTotal tax: " + String.valueOf(tax) + "\n" + 
    						"Total amount: " + String.valueOf(total + tax);	
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    	angelText.textProperty().addListener(new ChangeListener<String>() {
    		@Override 
    		public void changed(ObservableValue<? extends String> observable, String oldValue, 
    		        String newValue) {
    		        if (!newValue.matches("\\d*")) {
    		            angelText.setText(newValue.replaceAll("[^\\d]", ""));
    		        }
    			}
    				
    		});
    	
    	carrotText.textProperty().addListener(new ChangeListener<String>() {
    		@Override 
    		public void changed(ObservableValue<? extends String> observable, String oldValue, 
    		        String newValue) {
    		        if (!newValue.matches("\\d*")) {
    		            carrotText.setText(newValue.replaceAll("[^\\d]", ""));
    		        }
    			}
    				
    		});
    	
    	chiffonText.textProperty().addListener(new ChangeListener<String>() {
    		@Override 
    		public void changed(ObservableValue<? extends String> observable, String oldValue, 
    		        String newValue) {
    		        if (!newValue.matches("\\d*")) {
    		            chiffonText.setText(newValue.replaceAll("[^\\d]", ""));
    		        }
    			}
    				
    		});
    }
    
    

}
