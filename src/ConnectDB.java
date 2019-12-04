import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ConnectDB {

	MongoClientURI uri = new MongoClientURI(
			"mongodb+srv://michaelan:Q123456789@simplyrugby-wut4f.mongodb.net/test?retryWrites=true&w=majority");

	MongoClient mongoClient = new MongoClient(uri);
	MongoDatabase database = mongoClient.getDatabase("SimplyRugy");

	public MongoDatabase getDatabase() {
		return database;
	}


	//Gets the account details from collections

	public ConnectDB() {
	}

	public void authLogin(String username, String password, JFrame frame)
	{
		//Gets the account details from collections
		MongoCollection<Document> col = database.getCollection("Login");

		//Loops through the account details
		MongoCursor<Document> cur = col.find().iterator();


		boolean auth = false;
		label1:
			while (cur.hasNext()) {

				Document doc = cur.next();
				@SuppressWarnings({ "rawtypes", "unchecked" })
				List userList = new ArrayList(doc.values());

				//If statement to check if details are valid
				if (username.equals((String) userList.get(1)) && password.equals((String)userList.get(2)))
				{
					username = userList.get(1).toString();
					password = userList.get(2).toString();
					auth = true;
					//Displays who logged into the application
					JOptionPane.showMessageDialog(null," Welcome\n " + userList.get(1) + " to the system");
					//Used to send user to main menu and close login
					break label1;
				}
			}
		if (auth == true)
		{
			//Direct user to the menu if the details are valid
			Menu.MainMenu(null);
			frame.setVisible(false);
			frame.dispose();
		}
		else
		{
			//Displays message if invalid login details are input.
			JOptionPane.showMessageDialog(null,
					"Invalid username or password"
							+ "\nPlease enter a valid username or password.");
		}
	}
}