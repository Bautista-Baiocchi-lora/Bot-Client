package com.client.test;

public class ReflectionShit {

	// if (getAction == null) {
	// getAction = new Thread() {
	// public void run() {
	// while (!getAction.isInterrupted()) {
	// //27983909
	// eLogger.write("Action Listener Started!");
	// while (!getAction.isInterrupted()) {
	// int id = Int.getInstance().getFromIntArray(Constants.mainClass, Constants.menuActionID,
	// client.getClient(), 1);
	// int cmd1 = Int.getInstance().getFromIntArray(Constants.mainClass, Constants.menuActionCmd1,
	// client.getClient(), 1);
	// int cmd2 = Int.getInstance().getFromIntArray(Constants.mainClass, Constants.menuActionCmd2,
	// client.getClient(), 1);
	// int cmd3 = Int.getInstance().getFromIntArray(Constants.mainClass, Constants.menuActionCmd3,
	// client.getClient(), 1);
	// int cmd4 = Int.getInstance().getFromIntArray(Constants.mainClass, Constants.menuActionCmd4,
	// client.getClient(), 1);
	//
	// eLogger.write("cmd1: "+cmd1+" cmd2: "+cmd2+" cmd3: "+cmd3+ " cmd4 :"+cmd4+" id: "+id);
	// try {
	// Thread.sleep(500);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	// }
	// };
	//
	// getAction.start();
	// } else {
	// getAction.interrupt();
	// getAction = null;
	// eLogger.write("Stopped the shit");
	// }

	// public static Object getInterfaceObject(String clazz, String field, Object obj, int index) {
	// try {
	// Client client = Engine.client;
	// ClassLoader cl = client.classLoader;
	// Class<?> c = cl.loadClass(clazz);
	// Field f = c.getDeclaredField(field);
	// f.setAccessible(true);
	// Object arr = f.get(client.getClient());
	// return (Object) Array.get(arr, index);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	//
	//
	// }

	// public static Object getGraphics() {
	// try {
	// Client client = Engine.client;
	// ClassLoader cl = client.classLoader;
	// Class<?> c = cl.loadClass("");//Constants.getRSApplet
	// Field f = c.getDeclaredField("");//Constants.getGraphics
	// f.setAccessible(true);
	// return (Object) f.get(client.getClient());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	//
	// }

}
