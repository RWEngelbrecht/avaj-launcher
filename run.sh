rm -f simulation.txt
rm -f avaj/aircraft/*.class
rm -f avaj/simulator/*.class
rm -f avaj/simulator/interfaces/*.class
rm -f avaj/weather/*.class
javac avaj/simulator/Simulator.java
java avaj.simulator.Simulator scenario.txt
