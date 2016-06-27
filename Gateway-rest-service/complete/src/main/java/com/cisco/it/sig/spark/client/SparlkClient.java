package com.cisco.it.sig.spark.client;

import java.net.URI;

import com.ciscospark.Membership;
import com.ciscospark.Message;
import com.ciscospark.Room;
import com.ciscospark.Spark;

public class SparlkClient {

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
	public static void main(String[] args) {
		SparlkClient client = new SparlkClient();
		client.test();
	}
}
