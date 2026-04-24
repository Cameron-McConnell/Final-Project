Main.class: Main.java Season.java Player.java AnalyticsEngine.java
	javac -g Main.java Season.java Player.java AnalyticsEngine.java

run: Main.class
	java Main

clean:
	rm *.class

debug:
	jdb Main
