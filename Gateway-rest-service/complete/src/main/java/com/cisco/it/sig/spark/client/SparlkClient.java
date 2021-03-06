package com.cisco.it.sig.spark.client;

import java.net.URI;
import java.net.URISyntaxException;

import com.ciscospark.Membership;
import com.ciscospark.Message;
import com.ciscospark.Room;
import com.ciscospark.Spark;
import com.ciscospark.Webhook;

/**
 * SparlkClient is helper class for all interaction to spark
 * @author krchella
 *
 */
public class SparlkClient {
	/**
	 * To create Spark room
	 * @param roomName
	 * @return
	 */
	public Room createroom(String roomName){
		Spark spark = getSparkInstance();
	    Room room = new Room();
	    room.setTitle(roomName);
	    room = spark.rooms().post(room);
		return room;
		
	}

	/**
	 * To get Spark instance with configured bot token
	 * @return
	 */
	private Spark getSparkInstance() {
		Spark spark = Spark.builder()
				.baseUrl(URI.create("https://api.ciscospark.com/v1"))
				.accessToken("ZDZlOTM1ZjMtNGIzYi00ZTkzLTg5YzYtNTkyYTc1YjFjZWQ1MDU5YTFlODgtOGM5")
				.build();
		return spark;
	}
	
	/**
	 * To add the user as member in spark room 
	 * @param room
	 * @param userId
	 * @return
	 */
	public Membership addmember(Room room, String userId){
		Spark spark = getSparkInstance();
	    Membership membership = new Membership();
	    membership.setRoomId(room.getId());
	    membership.setPersonEmail(userId);
	    membership = spark.memberships().post(membership);
	    return membership;
	}
	
	/**
	 * To pst the message to the spark room
	 * @param message
	 */
	public void sendMessage(Message message){

		Spark spark = getSparkInstance();
	    spark.messages().post(message);

	}
	public void setWebhook(Room room, String string){
		Spark spark = getSparkInstance();
		Webhook webhook = new Webhook();
	    webhook.setEvent("created");
	    webhook.setResource("messages");
	    URI uri = null;
		try {
			uri = new URI("http://localhost:8080/greeting");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    webhook.setTargetUrl(uri);
	    webhook.setFilter("roomId="+room.getId());
	    webhook.setName(room.getId());
	    spark.webhooks().post(webhook);
	}
	
	private void test() {

	    // To obtain a developer access token, visit http://developer.ciscospark.com
	    String accessToken = "MjI5OGE0YWQtODVkYy00MzgxLTk0ZjAtM2RiODA2ZjdjMzQyMDllM2Y2NDYtNzVi";

	    // Initialize the client
	    Spark spark = Spark.builder()
	            .baseUrl(URI.create("https://api.ciscospark.com/v1"))
	            .accessToken(accessToken)
	            .build();

	    // List the rooms that I'm in
	    spark.rooms()
	            .iterate()
	            .forEachRemaining(room -> {
	                System.out.println(room.getTitle() + ", created " + room.getCreated() + ": " + room.getId());
	            });

	    // Create a new room
	    Room room = new Room();
	    room.setTitle("Hello World");
	    room = spark.rooms().post(room);


	    // Add a coworker to the room
	    Membership membership = new Membership();
	    membership.setRoomId(room.getId());
	    membership.setPersonEmail("wile_e_coyote@acme.com");
	    spark.memberships().post(membership);


	    // List the members of the room
	    spark.memberships()
	            .queryParam("roomId", room.getId())
	            .iterate()
	            .forEachRemaining(member -> {
	                System.out.println(member.getPersonEmail());
	            });


	    // Post a text message to the room
	    Message message = new Message();
	    message.setRoomId(room.getId());
	    message.setText("hi got my msg!");
	    spark.messages().post(message);
	    
	    // Share a file with the room
	    message = new Message();
	    message.setRoomId(room.getId());
	    message.setFiles(URI.create("http://example.com/hello_world.jpg"));
	    spark.messages().post(message);
}
/*	public static void main(String[] args) {
		SparlkClient client = new SparlkClient();
		client.test();
	}
*/}
