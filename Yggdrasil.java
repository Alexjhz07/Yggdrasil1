
package TeamProject;
import java.util.Scanner; //Import Scanner 

public class Yggdrasil{
    
    static String in, name; //UNIVERSAL VARIABLES
    static int health = 200, damage, smith = 11, statatk = 20, stathp = 200, coin, bless, mobdrop, mobhp, mobdmg, rng, lordhp = 2000, lorddmg; //UNIVERSAL NUMBERS
    
    public static void main(String [] args){ //Done this way so that I can go to any method I want for debugging.
        admin();
    }
    
    public static void start(){ //Starting Sequence
        Scanner input = new Scanner(System.in); 
        System.out.println("\n\n-YOU WAKE UP IN A FOREST WITH A MILD HEADACHE-\n\nWell, hello there friend! I just summoned you a moment ago!\nThere's been an incident, and this world needs your help.\nAre you ready to begin your adventure?\n(1)Yes! (2)No! (3)What are you talking about?");
        in = input.nextLine();

        if(in.equalsIgnoreCase("yes") || in.equalsIgnoreCase("yes!") || in.equalsIgnoreCase("1")){ //Answer Yes
            System.out.println("\nI like that Enthusiasm. Lets get right into it!");
        }else if(in.equalsIgnoreCase("no") || in.equalsIgnoreCase("no!") || in.equalsIgnoreCase("2")){ //Answer No
            System.out.println("\nWell... That was enthusiastic... Lets jump right into it!");
        }else if(in.equalsIgnoreCase("what") || in.equalsIgnoreCase("what?") || in.equalsIgnoreCase("3")){ //Answer What
            System.out.println("\nErrm... It's complicated. Here, let me explain:\n");
        }else{ //Invalid Answer
            System.out.println("\nHmm... Nevermind that then...\nLets move on!\n");
        }

        try{
            Thread.sleep(2000); //Pauses Program For Two Seconds (Unit is millisecond)
            story1();
        }
        catch(InterruptedException a){
            story1();
        }
}
  
    public static void story1(){ //Storyline 1
        System.out.println("\nWe're currently in the world of Yggdrasil.\nThough it may not seem like it through text, our world is in peril.\nOrcs and Ogres have suddenly started appearing from forests.\nThe demon lord's army is also on the move.\n");
        try{
            Thread.sleep(3000);
            story2();
        }
        catch(InterruptedException b){
            story2();
        }
}
  
    public static void story2(){ //Storyline 2
        Scanner input = new Scanner(System.in); 
        System.out.println("\nLuckily for the world, we have me, Ramiris, the relentless and sarcastic fairy who will save the world!\nBut for that to happen I need your help.\nAs a fairy, I cannot interact with the real world, so I've bestowed upon you the powers of a hero.\nOur goal is to stop the progression of the demon lord's army, and save the world together.\nWith your power and my guidance, there's no way we can lose\nSounds pretty awesome right?\n(1)Yeah, you could say that (2)Umm, what? I wanna go home. (3)...");
        in = input.nextLine();
        
        if(in.equalsIgnoreCase("yes") || in.equalsIgnoreCase("ye") || in.equalsIgnoreCase("y") || in.equalsIgnoreCase("1")){ //Answer Yes
            System.out.println("\nYep! I knew you would be able to see my greatness!");
        }else if(in.equalsIgnoreCase("no") || in.equalsIgnoreCase("n") || in.equalsIgnoreCase("2")){ //Answer No
            System.out.println("\nWell... I've already bestowed my power upon you, so no take backs!");
        }else if(in.equalsIgnoreCase("...") || in.equalsIgnoreCase("3")){ //Answer No
            System.out.println("\nHey! What's with the awkward silence?\nThere's no need for hostilities.\nI don't even know your name yet.");    
        }else{ //Invalid Answer
            System.out.println("\nHmm... A bit overwhelmed, are we...");
        }
        
        System.out.println("Tell me, what would your name happen to be?\n");
        name = input.next();
        System.out.println("\n" + name + ", huh? Not too bad sounding. I'll try to get used to it!\nLet's start off by heading into the Willowed Woods.\nI heard that there were goblins sighted near the area!\n");
        
        try{
            Thread.sleep(3000);
            story3();
        }
        catch(InterruptedException b){
            story3();
        }        
    }
    
    public static void story3(){ //Storyline 1
        System.out.println("\nThe demon lord resides in his castle.\nYou're free to enter it at anytime and damage the demon lord.\nAny damage done is saved, and you can escape with a guarantee.\nSo, our goal is to hit the mean guy a few times, run away to heal, then return and hit him some more.\nYou're free to head back to town at anytime and get upgrades for coins.\nMan, this is already getting me excited!\n");
        try{
            Thread.sleep(10000);
            forestTutorialMessage();
        }
        catch(InterruptedException b){
            forestTutorialMessage();
        }
}
    
    public static void forestTutorialMessage(){ //Entrance message: Willowed Woods Tutorial
        System.out.println("-ENTERING THE WILLOWED WOODS-\n");
        try{
            Thread.sleep(3000);
            forestTutorial();
        }
        catch(InterruptedException b){
            forestTutorial();
        }
    }
    
    public static void forestTutorial(){ //Forest tutorial code
        System.out.println("Woah, we're here! Isn't it beautiful?\nWell, you can't really see it, so I'll just describe it to you.\nTrees, flowers, and green grass. The forest has a rather pleasant floral aroma.\nBirds chir- Oop, heads up! Goblin approaching!");
        try{
            Thread.sleep(2000);
            goblinEncounter();
        }
        catch(InterruptedException b){
            goblinEncounter();
        }
    }
    
    public static void goblinEncounter(){ //Encounter message: Goblin
        System.out.println("\n-YOU ENCOUNTER A GOBLIN-\nGrawr!\n");
        mobhp = 20;
        try{
            Thread.sleep(2000);
            attackgoblin();
        }
        catch(InterruptedException b){
            attackgoblin();
        }
    }
    
    public static void goblin(){ //Goblin stats
        health = health - mobdmg;
        System.out.println("You have " + health + " health remaining.");
        mobhp = mobhp - damage;
        System.out.println("The goblin has " + mobhp + " health remaining.\n");
        
        if(health <= 0){ //Death
        System.out.println(name + ", don't do that!");
        death();
        }else if(mobhp <= 0 && health >= 0){ //Win
        mobdrop = 5 + (int)(6*Math.random());
        coin = coin + mobdrop;    
        System.out.println("You defeated the goblin!\nIt dropped " + mobdrop + " coins.\nYou now have " + coin + " coins in your bag.");
        explore();
        }else{
        attackgoblin();
        }
    }
    
    public static void attackgoblin(){ //Battling Goblin
        Scanner input = new Scanner(System.in); 
                
        System.out.println("-CHOOSE WHAT TO DO-\n(1)attack (2)run");
        in = input.nextLine();
        
        if(in.equalsIgnoreCase("1") || in.equalsIgnoreCase("attack") || in.equalsIgnoreCase("a")){ //Answer Attack
            damage = 10 + (int)(smith*Math.random());
            System.out.println("\nYou did " + damage + " damage to the goblin.");
            mobdmg = 5 + (int)(6*Math.random());
            System.out.println("You recieved " + mobdmg + " damage from the goblin.");
            goblin();
            
        }else if(in.equalsIgnoreCase("2") || in.equalsIgnoreCase("run") || in.equalsIgnoreCase("r")){ //Answer Run
            rng = 1 + (int)(3*Math.random());
            if(rng == 1){
            System.out.println("\nYou ran away back to town.");
            explore();
            }else{
            System.out.println("\nRun away failed.");
            mobdmg = 5 + (int)(6*Math.random());
            System.out.println("The goblin catches up to you and deals " + mobdmg + " damage.\nYou have " + health + " health remaining.");
            goblin();
            }
            
        }else{ //Invalid Answer
            System.out.println("\nInvalid attack\n");
            attackgoblin();
        }        
    }
    
    public static void demonEncounter(){ //Encounter message: Lower Demon
        System.out.println("\n-A DEMON APPROACHES YOU-\nHellooo, human!\nWould you like to be my next meal?\n");
        mobhp = 50;
        try{
            Thread.sleep(2000);
            attackdemon();
        }
        catch(InterruptedException b){
            attackdemon();
        }
    }
    
    public static void demon(){ //Demon stats
        health = health - mobdmg;
        System.out.println("You have " + health + " health remaining.");
        mobhp = mobhp - damage;
        System.out.println("The demon has " + mobhp + " health remaining.\n");
        
        if(health <= 0){ //Death
        System.out.println(name + ", don't do that!");
        death();
        }else if(mobhp <= 0 && health >= 0){ //Win
        mobdrop = 17 + (int)(6*Math.random());
        coin = coin + mobdrop;    
        System.out.println("You defeated the demon!\nIt dropped " + mobdrop + " coins.\nYou now have " + coin + " coins in your bag.");
        explore();
        }else{
        attackdemon();
        }
    }
    
    public static void attackdemon(){ //Battling Demon
        Scanner input = new Scanner(System.in); 
                
        System.out.println("-CHOOSE WHAT TO DO-\n(1)attack (2)run");
        in = input.nextLine();
        
        if(in.equalsIgnoreCase("1") || in.equalsIgnoreCase("attack") || in.equalsIgnoreCase("a")){ //Answer Attack
            damage = 10 + (int)(smith*Math.random());
            System.out.println("\nYou did " + damage + " damage to the demon.");
            mobdmg = 10 + (int)(6*Math.random());
            System.out.println("You recieved " + mobdmg + " damage from the demon.");
            demon();
            
        }else if(in.equalsIgnoreCase("2") || in.equalsIgnoreCase("run") || in.equalsIgnoreCase("r")){ //Answer Run
            rng = 1 + (int)(4*Math.random());
            if(rng == 1){
            System.out.println("\nYou ran away.");
            explore();
            }else{
            System.out.println("\nRun away failed.");
            mobdmg = 10 + (int)(6*Math.random());
            System.out.println("The demon flies up to you and throws a fireball, dealing " + mobdmg + " damage to you.\nYou have " + health + " health remaining.");
            demon();
            }
            
        }else{ //Invalid Answer
            System.out.println("\nInvalid attack\n");
            attackdemon();
        }        
    }
    
    public static void chest(){
        rng = (int)(4*Math.random());
        switch(rng){
            case 0:
                System.out.println("\nYou find an abandoned chest in a merchant wagon!");
                rng = 1 + (int)(20*Math.random());
                break;
            case 1:
                System.out.println("\nWandering inside a cave, you see something shiny.\nYou get closer and find a vase filled with coins!");
                rng = 5 + (int)(26*Math.random());
                break;
            case 2:
                System.out.println("\nIn the forest, you find a box stuck under a tree.\nOpening it, you find it brimming with coins!");
                rng = 10 + (int)(31*Math.random());
                break;
            case 3:
                System.out.println("\nOn a mountain top, you find a suspicious looking small rock.\nIt looks man made, and sounds hollow when you clang it with your sword.\nYou break it open, revealing a lot of coins.");
                rng = 10 + (int)(41*Math.random());
                break;
        }
                
        coin = coin + rng;
        
        System.out.println("\nYou gained " + rng + " coins! You now have " + coin + " coins saved up.");        
        try{
        Thread.sleep(3000);
        explore();
        }
        catch(InterruptedException b){
        explore();
        }
    }
    
    public static void fountain(){
        rng = (int)(4*Math.random());
        switch(rng){
            case 0:
                System.out.println("\nYou find a potion inside a merchant's cart!");
                rng = 1 + (int)(20*Math.random());
                break;
            case 1:
                System.out.println("\nWandering inside a cave, you see something shiny.\nYou get closer and find a vase filled with holy water!");
                rng = 5 + (int)(26*Math.random());
                break;
            case 2:
                System.out.println("\nIn the forest, you find a box stuck under a tree.\nOpening it, you find many viles of healing water!");
                rng = 10 + (int)(31*Math.random());
                break;
            case 3:
                System.out.println("\nOn a mountain top, you find a suspicious looking small rock.\nIt looks man made, and sounds like water when you clang it with your sword.\nYou sip some of the water from a small hole you drilled with your sword.");
                rng = 10 + (int)(41*Math.random());
                break;
        }
        
        health = health + rng;
        
        System.out.println("\nYou gained " + rng + " health! You now have " + health + " health remaining");  
        try{
        Thread.sleep(3000);
        explore();
        }
        catch(InterruptedException b){
        explore();
        }
    }
    
    public static void dragonEncounter(){ //Encounter message: Dragon
        System.out.println("\n-A DRAGON LANDS IN FRONT OF YOU-\nHWARRRRRRR!\n");
        mobhp = 500;
        try{
            Thread.sleep(2000);
            attackdragon();
        }
        catch(InterruptedException b){
            attackdragon();
        }
    }
    
    public static void dragon(){ //Dragon stats
        health = health - mobdmg;
        System.out.println("You have " + health + " health remaining.");
        mobhp = mobhp - damage;
        System.out.println("The dragon has " + mobhp + " health remaining.\n");
        
        if(health <= 0){ //Death
        System.out.println(name + ", don't do that!");
        death();
        }else if(mobhp <= 0 && health >= 0){ //Win
        mobdrop = 50 + (int)(100*Math.random());
        coin = coin + mobdrop;    
        System.out.println("You defeated the dragon!\nIt dropped " + mobdrop + " coins.\nYou now have " + coin + " coins in your bag.");
        explore();
        }else{
        attackdragon();
        }
    }
    
    public static void attackdragon(){ //Battling Dragon
        Scanner input = new Scanner(System.in); 
                
        System.out.println("-CHOOSE WHAT TO DO-\n(1)attack (2)run");
        in = input.nextLine();
        
        if(in.equalsIgnoreCase("1") || in.equalsIgnoreCase("attack") || in.equalsIgnoreCase("a")){ //Answer Attack
            damage = 10 + (int)(smith*Math.random());
            System.out.println("\nYou swing your sword at the dragon, doing " + damage + " damage to the dragon.");
            mobdmg = 40 + (int)(6*Math.random());
            System.out.println("You recieved " + mobdmg + " damage from the dragon.");
            dragon();
            
        }else if(in.equalsIgnoreCase("2") || in.equalsIgnoreCase("run") || in.equalsIgnoreCase("r")){ //Answer Run
            rng = 1 + (int)(2*Math.random());
            if(rng == 1){
            System.out.println("\nThe dragon loses interest in you.\nYou run away.");
            explore();
            }else{
            System.out.println("\nRun away failed.");
            mobdmg = 40 + (int)(6*Math.random());
            System.out.println("The dragon flies up to you and throws a fireball, dealing " + mobdmg + " damage to you.\nYou have " + health + " health remaining.");
            dragon();
            }
            
        }else{ //Invalid Answer
            System.out.println("\nInvalid attack\n");
            attackdragon();
        }        
    }
    
    public static void mysteriousworm(){ //Mysterious Worm
        Scanner input = new Scanner(System.in); 
        
        System.out.println("\nYou encounter a mysterious worm. What do you do?\n(1)Eat it (2)Kill it (3)Leave it alone");
        in = input.nextLine();
        
        if(in.equalsIgnoreCase("1") || in.equalsIgnoreCase("eat") || in.equalsIgnoreCase("eat it")){
            health = health + 1000;
            System.out.println("\nThe world around you spins.\nYou're falling... or are you flying?\nGravity is crushing you...You wake up feeling stronger!\n\nYour health has temporarily increased to " + health + ".");
            explore();
        }else if(in.equalsIgnoreCase("2") || in.equalsIgnoreCase("kill") || in.equalsIgnoreCase("kill it")){
            coin = coin + 1000;
            System.out.println("\nThe innards of the worm shine.\nThe entrails let loose a small stream of gold.\nYou collect the stream in a bag, the water solidifies into gold.\nYour gold has been increased to " + coin + ".");
            explore();
        }else if(in.equalsIgnoreCase("3") || in.equalsIgnoreCase("leave") || in.equalsIgnoreCase("leave it alone")){
            System.out.println("\nThe worm looks up at you thankfully.\nIt seems to whisper something but you don't catch it.\nThe worm crawls away and you head back to town.");
            lordhp = 20;
            explore();
        }else{ //Invalid Answer
            System.out.println("\nInvalid action\n");
            mysteriousworm();
        }
    }
    
    public static void explore(){ //Main Explore Method
        Scanner input = new Scanner(System.in); 
                
        System.out.println("\n-WILLOWED WOODS-\nWhat would you like to do next?\n(1)Continue exploring (2)Head back to town (3)Fight the demon lord (4)Show stats (5)Hear the instructions again");
        in = input.nextLine();
        
        if(in.equalsIgnoreCase("1")){ //Explore
            System.out.println("\nYou wander deeper into the forest");
            rng = (int)(1000*Math.random());
            if(rng >= 0 && rng <= 500){ //Goblin
                goblinEncounter();
            }else if(rng >= 501 && rng <= 700){ //Lower Demon
                demonEncounter();
            }else if(rng >= 701 && rng <= 800){ //Chest
                chest();
            }else if(rng >= 801 && rng <= 897){ //Fountain
                fountain();
            }else if(rng >= 898 && rng <= 998){ //Dragon
                dragonEncounter();
            }else{ //Easter Egg
                mysteriousworm();
            }
        }
        
        else if(in.equalsIgnoreCase("2")){ //Town
            System.out.println("\nYou head back to town\n");
            town();
        }
        
        else if(in.equalsIgnoreCase("3")){ //Demon lord
            System.out.println("\nYou march toward the demon lord's domain.\n");            
            try{
            Thread.sleep(3000);
            demonlordEncounter();
            }
            catch(InterruptedException b){
            demonlordEncounter();
            }
        }
        
        else if(in.equalsIgnoreCase("4")){ //Stat       
            stat();
        }
        
        else if(in.equalsIgnoreCase("5")){ //Instructions
            System.out.println("\nThe demon lord resides in his castle.\nYou're free to enter it at anytime and damage the demon lord.\nAny damage done is saved, and you can escape with a guarantee.\nSo, our goal is to hit the mean guy a few times, run away to heal, then return and hit him some more.\nYou're free to head back to town at anytime and get upgrades for coins.\nMan, this is already getting me excited!\n");
            try{
            Thread.sleep(3000);
            explore();
            }
            catch(InterruptedException b){
            explore();
            }
        }

        else{ //Invalid Answer
            System.out.println("\nInvalid action.\n");
            try{
            Thread.sleep(2000);
            explore();
            }
            catch(InterruptedException b){
            explore();
            }
        }
    }
    
    public static void stat(){
        System.out.println("\nCharacter stats of " + name + "\nCurrent Health: " + health + "\nMaximum Health: " + stathp + "\nMaximum Damage: " + statatk + "\nCoins in bag: " + coin + "\n\nCurrent number of blessings: " + bless + "\nCurrent demonlord hp: " + lordhp);
        
        try{
        Thread.sleep(3000);
        explore();
        }
        catch(InterruptedException b){
        explore();
        }
    }
    
    public static void town(){
        Scanner input = new Scanner(System.in); 
        
        System.out.println("\n-TOWN OF YGGDRASIL-\nWhere would you like to go?\n(1)Back to the forest (2)Doctor (3)Blacksmith (4)Druid (5)Church");
        in = input.nextLine();
        
        if(in.equalsIgnoreCase("1")){ //Explore
            System.out.println("\nYou head back out into the Willowed Woods.\n");
            explore();
        }
        
        else if(in.equalsIgnoreCase("2")){ //Doctor
            doctor();
        }
        
        else if(in.equalsIgnoreCase("3")){ //Blacksmith
            smith();
        }
        
        else if(in.equalsIgnoreCase("4")){ //Druid
            druid();
        }
        
        else if(in.equalsIgnoreCase("5")){ //Church
            church();
        }
        else{ //Invalid Answer
            System.out.println("\nInvalid action.\n");
            try{
            Thread.sleep(2000);
            town();
            }
            catch(InterruptedException b){
            town();
            }
        }
    }
    
    public static void doctor(){ //Doctor Method
        Scanner input = new Scanner(System.in); 
        
        System.out.println("\n-DOCTOR AUBERT-\nWould you like to heal back to full health for 40 coins?\n(1)Yes (2)No");
            in = input.nextLine();
            if(in.equalsIgnoreCase("1")){
                if(coin >= 40 && health < stathp){
                    health = stathp;
                    coin = coin - 40;
                    System.out.println("\nYou pay 40 coins to Aubert. She heals you back to full health.\nYour health is now " + health + ".\nYou have " + coin + " coins remaining.\n");
                    try{
                    Thread.sleep(2000);
                    town();
                    }
                    catch(InterruptedException b){
                    town();
                    }
                }else if(health >= stathp){
                    System.out.println("\nYour health is already full.\n");
                    try{
                    Thread.sleep(2000);
                    town();
                    }
                    catch(InterruptedException b){
                    town();
                    }
                }
                else{
                    System.out.println("\nYou do not have enough coins.\n");
                    try{
                    Thread.sleep(2000);
                    town();
                    }
                    catch(InterruptedException b){
                    town();
                    }
                }
            }else if(in.equalsIgnoreCase("2")){
                town();
            }else{
                System.out.println("\nInvalid response\n");
                doctor();
            }
    }
    
    public static void smith(){ //Smith Method
        Scanner input = new Scanner(System.in); 
        
        System.out.println("\n-BLACKSMITH KUROBE-\nHello There!\nWould you like your sword refined for 30 coins?\nYour maximum damage will increase by 10\n(1)Yes (2)No");
            in = input.nextLine();
            if(in.equalsIgnoreCase("1")){
                if(coin >= 30){
                    smith = smith + 10;
                    coin = coin - 30;
                    statatk = smith + 9;
                    System.out.println("\nYou pay 30 coins to Kurobe. Your sword has been refined.\nYour maximum damage is now " + statatk + ".\nYou have " + coin + " coins remaining.\n");
                    try{
                    Thread.sleep(2000);
                    town();
                    }
                    catch(InterruptedException b){
                    town();
                    }
                }
                else{
                    System.out.println("\nYou do not have enough coins.\n");
                    try{
                    Thread.sleep(2000);
                    town();
                    }
                    catch(InterruptedException b){
                    town();
                    }
                }
            }else if(in.equalsIgnoreCase("2")){
                town();
            }else{
                System.out.println("\nInvalid response\n");
                smith();
            }
    }
    
    public static void druid(){ //Druid Method
        Scanner input = new Scanner(System.in); 
        
        System.out.println("\n-DRUID IFRIT-\nHey, " + name + "!\nWould you like to purchase a fruit of life for 30 coins?\nThis will increase your maximum health by 10\n(1)Yes (2)No");
            in = input.nextLine();
            if(in.equalsIgnoreCase("1")){
                if(coin >= 30){
                    health = health + 10;
                    coin = coin - 30;
                    stathp = stathp + 10;
                    System.out.println("\nYou pay 30 coins to Ifrit. You feel refreshed.\nYour maximum health is now " + stathp + ".\nYou have " + coin + " coins remaining.\n");
                    try{
                    Thread.sleep(2000);
                    town();
                    }
                    catch(InterruptedException b){
                    town();
                    }
                }
                else{
                    System.out.println("\nYou do not have enough coins.\n");
                    try{
                    Thread.sleep(2000);
                    town();
                    }
                    catch(InterruptedException b){
                    town();
                    }
                }
            }else if(in.equalsIgnoreCase("2")){
                town();
            }else{
                System.out.println("\nInvalid response\n");
                druid();
            }
    }
    
    public static void church(){ //Church Method
        Scanner input = new Scanner(System.in); 
        
        System.out.println("\n-FATHER EDGAR-\nHello again, " + name + "!\nAre you here to be blessed for 200 coins?\nBlessings allow you an extra life after death\n(1)Yes (2)No");
            in = input.nextLine();
            if(in.equalsIgnoreCase("1")){
                if(coin >= 200){
                    bless = bless + 1;
                    coin = coin - 200;
                    System.out.println("\nYou hand 200 coins over the the father.\nYou feel a holy presence watch over you.\nYour blessing count is now at " + bless + ".\nYou have " + coin + " coins remaining.\n");
                    try{
                    Thread.sleep(2000);
                    town();
                    }
                    catch(InterruptedException b){
                    town();
                    }
                }
                else{
                    System.out.println("\nYou do not have enough coins.\n");
                    try{
                    Thread.sleep(2000);
                    town();
                    }
                    catch(InterruptedException b){
                    town();
                    }
                }
            }else if(in.equalsIgnoreCase("2")){
                town();
            }else{
                System.out.println("\nInvalid response\n");
                church();
            }
    }
        
    public static void demonlordEncounter(){ //Encounter message: Demon Lord
        System.out.println("\n-YOU APPROACH THE DEMON LORD DIABLO-\n");
        rng = (int)(4*Math.random());
        switch(rng){
            case 0:
                System.out.println("\nYou dare oppose me, mortal?\nCome closer and I'll show you the easy way out.");
                break;
            case 1:
                System.out.println("\nHrm... Ramiris sent you, eh?\nThat fairy never ceases to annoy me.\nI'll strangle her with my own hands once I'm done with you.");
                break;
            case 2:
                System.out.println("\nAh, you're from that darned Ramiris again.\nOh, why has the world cursed me with such an aggravating being?");
                break;
            case 3:
                System.out.println("\nI heard that " + name + " was your name.\nI'll make sure to forget after I turn you into my minion.");
                break;
        }
        
            try{
            Thread.sleep(3000);
            attackdemonlord();
            }
            catch(InterruptedException b){
            attackdemonlord();
            }
    }
    
    public static void demonlord(){ //Demonlord stats
        health = health - lorddmg;
        System.out.println("You have " + health + " health remaining.");
        lordhp = lordhp - damage;
        System.out.println("The demon lord has " + lordhp + " health remaining.\n");
        
        if(health <= 0){ //Death
        System.out.println(name + ", you're a weak runt after all.");
        death();
        }else if(lordhp <= 0 && health > 0){ //Win
            try{
            System.out.println("\n-THE DEMON LORD FALLS-\n");    
            Thread.sleep(5000);
            win();
            }
            catch(InterruptedException b){ 
            System.out.println("\n-THE DEMON LORD FALLS-\n");     
            win();
            }        
        }else{
        attackdemonlord();
        }
    }
    
    public static void attackdemonlord(){ //Battling Demonlord
        Scanner input = new Scanner(System.in); 
                
        System.out.println("\n-CHOOSE WHAT TO DO-\n(1)attack (2)run");
        in = input.nextLine();
        
        if(in.equalsIgnoreCase("1") || in.equalsIgnoreCase("attack") || in.equalsIgnoreCase("a")){ //Answer Attack
            damage = 10 + (int)(smith*Math.random());
            System.out.println("\nYou did " + damage + " damage to the demonlord.");
            rng = (int)(4*Math.random());
            switch(rng){
                case 0:
                    System.out.println("The demon lord shoots a blade of darkness your way.");
                    lorddmg = 20 + (int)(31*Math.random());
                    break;
                case 1:
                    System.out.println("The grounds turn into flames and fire engulfs you.\nYou escape, a bit scathed.");
                    lorddmg = 20 + (int)(46*Math.random());
                    break;
                case 2:
                    System.out.println("A volley of dark projectiles launch your way.\nMost sail past your head, but a few hit your body.");
                    lorddmg = 20 + (int)(51*Math.random());
                    break;
                case 3:
                    System.out.println("The demon lord encapsulates a ball of blood with flames above his head.\nIt explodes, releasing a boiling, bloody mist.");
                    lorddmg = 20 + (int)(56*Math.random());
                    break;
            }
            System.out.println("You recieved " + lorddmg + " damage from the demonlord.");
            demonlord();
            
        }else if(in.equalsIgnoreCase("2") || in.equalsIgnoreCase("run") || in.equalsIgnoreCase("r")){ //Answer Run
            System.out.println("\nYou ran away.");
            explore();
            
        }else{ //Invalid Answer
            System.out.println("\nInvalid attack\n");
            attackdemonlord();
        }        
    }
    
    public static void death(){ //Death Sequence
        System.out.println("\n-YOUR HEALTH HAS REACHED 0-\n\nNo! " + name + "!");
        
        if(bless > 0){
            bless = bless - 1;
            health = stathp;
            System.out.println("\n\nYou're down of the ground, yet you feel peaceful.\nThere's no rush.\nYou can feel the presence of Ramiris; she's calm.\nThe world around you falls as you're lifted into the sky.\nAnother chance, huh?\nLet's use it wisely...\n");
            
            try{
            Thread.sleep(5000);
            System.out.println("\n-YOU HAVE BEEN REVIVED BACK IN TOWN-\n\nYour blessing count is now " + bless + ".\n");
            explore();
            }
            catch(InterruptedException b){
            System.out.println("\n-YOU HAVE BEEN REVIVED BACK IN TOWN-\n\nYour blessing count is now " + bless + ".\n");    
            explore();
            }
            
        }else{
            System.out.println("\n\nThe lids of your eyes tire.\nYou're blacking out into an eternal slumber.\nThe voice of Ramiris calls out to you, but you're unable to reply.\nAs you drift off, the world continues to move.\nA scornful laugh escapes your lips; nothing has changed.\nLet's hope for a better run in the next life...\n");
            
            try{
            Thread.sleep(5000);
            retry();
            }
            catch(InterruptedException b){
            retry();
            }
        }
    }
    
    public static void win(){ //Win Method
        System.out.println("You look up at the clouds.\nThe blood red colour of the sky seems to fade to a grey,\nand you're able to finally bathe in the warmth of the sun.\nFor the first time in centuries,\nsunlight shines upon the kingdom of Diablo.\n\nOn the ground before you, Diablo lies still.\nHis head slowly tilts towards you. He's smiling.\n\n\"The curse is finally lifted...\"\n\n\"Yes,\" you hear Ramiris reply.\n\n\"Will it hurt? Death, I mean.\"\n\n\"No,\" comes the answer from Ramiris.\n\n\"Come closer please, " + name + ".\"\n\nYou feel obliged to listen.\nDiablo radiates no evil, he's now just another human.\nHe peers into your eyes with curiosity\n\n\"Ah, thank you.\nI'm sorry... I didn't get a good look at you earlier.\nThank you, for ending this for me.\"\n\nDiablo's eye lids fall peacefully.\nGravity takes hold of him again.\nHis arms fall to the earth.\nHis face turns to face the sky.\n\nThe clouds clear a way for light.\nFron his feet, the light works its way up to his head.\nDiablo's body vanishes with a brilliant glow.\nYou think you hear him once more from the light.\n\n\"So dark...\"\n\nYou never catch the rest of the words,\nbut that doesn't matter anymore.\nBalance has been restored once again.\n\nYou return to town once again.");
        
        try{
            Thread.sleep(10000);
            retry();
            }
            catch(InterruptedException b){
            retry();
            }
    }
    
    public static void retry(){ //Win Method
        Scanner input = new Scanner(System.in); 
        
        System.out.println("\n-END-\n\nThank you for playing, " + name + "!\n\n-Would you like to replay from the start?-\n\n(1)Yes (2)No");
        in = input.nextLine();
        
        if(in.equalsIgnoreCase("1") || in.equalsIgnoreCase("yes") || in.equalsIgnoreCase("y")){
            health = 200;
            smith = 11;
            lordhp = 2000;
            bless = 0;
            coin = 0;
            stathp = health;
            statatk = smith + 9;
            start();
        }else if(in.equalsIgnoreCase("2") || in.equalsIgnoreCase("no") || in.equalsIgnoreCase("n")){
            System.out.println("\n-Thanks again for playing!-\n");
            System.exit(0);
        }else{
            System.out.println("\n-Invalid Answer-\n");
            retry();
        }        
    }
    
    public static void admin(){ //Admin Cheat
        coin = 10000;
        health = 2000;
        smith = 101;
        stathp = health;
        statatk = smith + 9;
        explore();
    }    
    
}
