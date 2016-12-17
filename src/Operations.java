
public class Operations {
	public static DataSend data;
	public static void heat() {
		System.out.println("The silo is being heated.");
		SiloGui.txtarea.append("The silo is being heated.\n");
		try{	
			DataSend.string = "heat";
			System.out.println("sending data");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public static void water() {
		System.out.println("The water pump is online.");
		SiloGui.txtarea.append("The water pump is online.\n");
		try{	
			DataSend.string = "water";
			System.out.println("sending data");
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void mixer() {
		System.out.println("The mixer is online.");
		SiloGui.txtarea.append("The mixer is online.\n");
		try{	
			DataSend.string = "mixer";
			System.out.println("sending data");
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
