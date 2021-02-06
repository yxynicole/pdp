## Project 1 Reptile House
### About/Overview. 
This program implements a tracking system for a Reptile Houses which house reptiles and amphibians in a number of different habitats.

### How To Run
		cick run and no argument is needed to run the jar file.
        
### How to Use the Program 
Please refer to drive class
   
### Description of Example Runs
In drive class, 
1. Create a Reptile house object
2. Create n empty habitats and add them to reptile house
3. Use speciesFactory to create Species
4. Add individual animal into reptile house
5. Execute report methods on ReptileHouse and Habitat class to print the result

### Design/Model Changes. 

1. I added interfaces. In this project, adding interfaces promotes information hiding.
2. I avoided using an enumeration to categorize reptile and amphibian. Instead I used inheritance instead.

### Assumptions.
	- The animals of the same spcies have the same body size. For example, if a tree frog is small, then every instance of tree frog is in small size.
	- Time complexity is not optimal.
	- The report can be only printed on standard output
	- There is no interactive uesr interface.

