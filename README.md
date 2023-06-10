## LDTS Project Intermediate Report

## LDTS Project L14G01 - Pokémon

Pokémon is a popular RPG game where the player travels through a map encountering wild Pokémons and trainers to fight. The player builds a carefully selected collection of pokémons, each with different types and stats. There's certain strengths and weaknesses to each type of Pokémon, so diversity is key when capturing Pokémons. Trainers have multiple Pokemóns, such as the player, and offer a greater challenge compared to wild Pokémons found in tall grass throughout the map. Defeat the trainer so he goes away, often clearing useful paths.
 * This project was developed by Miguel Dionísio (up202108788@fe.up.pt), Rúben Esteves (up202006479@fe.up.pt) and Tomás Maciel (up202006845@fe.up.pt).

![projectldtsgif](https://user-images.githubusercontent.com/92651281/209434982-d12d967b-f32d-41cc-85a3-94622f3b0a36.gif)


### CONTROLS
* Inventory (I)
* Pokedéx (P)
* Return/Quit (Q)
* Use Potion on selected Pokemon (ENTER while on Inventory)
* Show Pokemon stats (ENTER while on Pokedex)

### IMPLEMENTED FEATURES

**Multiple maps composing the game's world**
* This feature was implemented after the game presentation on the last practical class.
* Using the arrow keys, the player can move throughout the world, composed by five maps. Travel to the edge of your current map to go to another one.
Each map is generated through a text file, containing characters that allows the map to be drawn accordingly

![image](https://user-images.githubusercontent.com/92651281/209434257-59e3c40d-9c6d-4813-a06c-826df6020d8b.png)


**Dynamic player appearance**
* This feature was implemented after the game presentation on the last practical class.
* Your chosen pokemon can be seen following the player throughout the map.

![image](https://user-images.githubusercontent.com/92651281/209434181-0d800af1-0084-40d9-9373-fa8171ec5ec9.png)


**Strategical Battle System**
* Fighting requires choosing proper attacks according to the opponent's type. Each type of pokemon receives more damage from a another specifyc type, for example a fire Pokemon will receive great damage from water attacks. Pokemon types can be identified through text color.
* Orange represents Fire
* Blue represents Water
* Brown represents earth
* Yellow represents Electric

![image](https://user-images.githubusercontent.com/92651281/209434290-f79633dc-63d1-41f2-b2dd-967e9532c737.png)


**Find various Pokemons to fight and/or capture when walking through tall grass.**
* When walking through tall grass, the player can encounter random wild Pokemons, and choose between fighting them, trying to capture using pokeballs or run.

**Encounter other Trainers and fight them..**
* This feature was implemented after the game presentation on the last practical class.
* They can be identified as the picture below. Careful, they have multiple Pokémons. Battle strategically, choosing the correct attack type depending on the opponent's Pokemon to increase damage.

![image](https://user-images.githubusercontent.com/93996462/209374291-d1e3e3c0-25de-4cce-8d04-ff8ea0126e23.png)

**Use potions to heal your wounded Pokemons and Pokeballs to capture other Pokemons. These items can be found randomly throughout the world.**
* Check your Inventory to know how many Pokeballs and potions you have left.
* Your potions will be used on the pokemon you have selected as your main
* The following screenshots show how these items look.

![image](https://user-images.githubusercontent.com/93996462/209374617-67ccab3f-29ef-48a9-be79-fc6a365e6b09.png)
![image](https://user-images.githubusercontent.com/93996462/209374790-d0d9479b-7a33-4f76-8a83-2bcc249f4d51.png)

**Check your pokemons stats, attacks and level with your pokedex**
* Here you can see how much HP/ATK/DEF/SPD your pokemon has.
* You can see whats your pokemons level (all pokemon evolve at level 3).
* You can see it's attacks and their type.
* You can select a pokemon as your main so he's the one you use on your next battle.

![image](https://user-images.githubusercontent.com/92651281/209434492-00bc6ccc-9ff5-4c0e-86fb-cb523f468b7d.png)
![image](https://user-images.githubusercontent.com/92651281/209434506-e0a75717-4d19-4623-901f-aaac077897b4.png)



### DESIGN
#### HAVING MULTIPLE ENVIRONMENTS/WINDOWS

**Problem in Context**

Our game switches very often between the world view, battle, menu, inventory and pokedex, so we had to come up with a way to easily switch between these.

**The Pattern**

We have applied the State pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation. This pattern allowed to address the identified problems because we could switch the state, which means switch to another implementation. This will allows us to change between the "world" environment and the "battle" environment without many problems.

**Implementation**

State class:

![image](https://user-images.githubusercontent.com/85106282/209406983-b33936b1-1744-42ce-bcf2-413f9474153b.png)

World State:

![image](https://user-images.githubusercontent.com/85106282/209407021-8d4f2677-09db-4bf8-a2e3-e18c68578c29.png)


**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- It simplifies the code, by eliminating the conditionals associated with the states; instead, polymorphism is now used.
- Organize the code related to particular states into separate classes. So we have now more classes and instances to manage, but still in a reasonable number.
- By using a stack of states and using the topmost as current one, we were able to return to previous states by simply popping the topmost one. This is extremely useful as it allows us to return easily to the world state after battles or using the pokedex/inventory.

***

#### SIMPLIFYING POKEMON CREATION
**Problem in Context**

The problem we were facing was how to create pokémons in a simple way, avoiding having a lot of classes created, which is a bad practice..

**The Pattern**

We have applied the Builder pattern. This pattern allows us to construct complex objects step by step. Basically, we can produce different types of an object with the same construction code.
In our case, this is very useful, because we will have pokémons of different types, and to create all of them we will use the same code, which is very efficient.

**Implementation**

![image](https://user-images.githubusercontent.com/85106282/209402975-7c77d262-8380-401c-aa94-e4b5d7b7df11.png)
![image](https://user-images.githubusercontent.com/85106282/209403012-ee440646-0ee6-4801-bd66-308cfea6250e.png)
![image](https://user-images.githubusercontent.com/85106282/209403026-f7521366-b668-4c5d-8dba-67e47a1c6337.png)
![image](https://user-images.githubusercontent.com/85106282/209403043-5bc6a802-ab3c-4c28-9804-654e27e6d600.png)


**Consequences**

The use of the Builder Pattern in the current design allows the following benefits:

- The construction of each object (in our case, pokémon) is done step by step.
- We will be able to use the same construction code to build different pokémons.
- We can isolate construction code, which is very complex, from the logic of the product.

***

#### Code Organization
**Problem in Context**

The problem we were facing was how to organize our code in an in organized and intuitive way, because we wanted to have our application code organized.

**The Pattern**

To achieve this, we applied the MVC (Model-View-Controller). This allows us to divide the related program logic into three interconnected elements (model, view and controller). The model represents the data, the view displays the model data and sends user actions to the controller. The controller provides data to the view, and interprets user actions.

**Implementation**

![image](https://user-images.githubusercontent.com/85106282/209406777-f3f3109b-4a4b-4d26-9345-8a5daa541d78.png)

Model example (battle):

![image](https://user-images.githubusercontent.com/85106282/209406813-8ae465a0-087a-4efa-bdcb-4bf6ada6406b.png)

View example (MapViewer):

![image](https://user-images.githubusercontent.com/85106282/209406854-9c58ef7b-f1de-4735-84c1-6cb103219061.png)

Controller example (TrainerBattleController):

![image](https://user-images.githubusercontent.com/85106282/209406895-b5d5ba2c-8727-4890-9937-77dc22f7d43f.png)



**Consequences**

The use of the MVC in the current design allows the following benefits:

- Faster development process
- The modification doesn't affect the entire model
- Ability to provide multiple views


### UML DIAGRAM 

![ProjetoUML drawio](https://user-images.githubusercontent.com/92651281/209432498-30f9951f-2105-4530-9fd0-5f85743c30ab.png)


### TESTING

### Screenshot of coverage report

![image](https://user-images.githubusercontent.com/85106282/209402592-40eafe2e-e15b-4adb-b2c5-a2a4a614be38.png)

We tried to use Pitest for mutation testing but we couldn't get pitest to work. When we tried to use pitest it generated a report with a result of 0% and a test stregnth of 0/0, after some digging we discovered that pitest wasn't detecting our tests. After a lot of tries we decided to take a different approach and install pitest as a plugin of intelIJ and running it by right clicking the test folder but we encountered errors such as "Mutation testing requires a green suite." which should mean our tests dont pass but as you can see in our report, all tests pass.

We have already implemented some tests, to make sure that our code works the way we pretend to.

* Map Test (with mocks)

![image](https://user-images.githubusercontent.com/85106282/204062301-ef337011-23b6-4bd6-abc8-0bedbfd685fa.png)

* Position Test

![image](https://user-images.githubusercontent.com/85106282/204062373-8dc53249-2d3a-4892-ad45-745c94ba488c.png)

* Player Controller Test

![image](https://user-images.githubusercontent.com/85106282/209402671-121151d8-108c-47a2-b63e-23758a10296c.png)

As you can see below, all the tests are passing.

![image](https://user-images.githubusercontent.com/85106282/204062432-7850158a-0cfc-4512-b737-fabfa1088392.png)

### SELF-EVALUATION

- Miguel Dionísio: 33,3%
- Rúben Esteves: 33,3%
- Tomás Maciel: 33,3%
