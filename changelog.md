## Indev : Laying the base elements of the game. 

### Indev 0.2 : 
The clicker game`s git repo. have some problems, now switching to a new repo. , logs from before maybe lost.

### Indev 0.2.1 : 
Added machine and recipe to game, fixed <code>materialFactory</code>.
Material`s auto item creator is currently under devoloping.

## Alpha : Testing and start making real game 

### alpha 1.0.0 : 
Testing and debugging

### alpha 1.0.1 : 
Make better repo.

### alpha 1.0.2 : 
Redone the gui.

### alpha 1.1.0 : 
Now every lib is finished, it`s time to make some real game!

### alpha 1.1.1 : 
The "lang" property of the configs is now useable, yay!
Also made some GUI in the vanilla <code>JFrame</code> and add some random things.

### alpha FIX1 : 
Emergency fix on the newly added <code>reg</code> type, added the method "add" and "lenth"

### alpha 1.2.0 : 
Changed name of the game to Omni com., made save and tried to make a local server and client (Note : it doesn\`t works, Note2 : the peice of code is in <code>vanilla.main.createGame</code>, can anybody give me some help???). The server and client is W.I.P, the fandom website is also W.I.P (official fandom? What`s that?).

### alpha 1.2.1 : 
Fixed the client and server of the vanilla plugin, added run.bat for compiling and running the game.

### alpha 1.2.2 : 
Redone the game types (<code>gts</code>) and factories of <code>src</code>. Orignally I was working on the client but I changed to a new computer and progress reset.

### alpha 1.2.3 :
Redone the compiling part. Added <code>qrun</code> and <code>qqrun</code> standing for quick run and quick quick run.

### alpha 1.2.4 :
Redone the core of vanilla plugin. The orignal plugin was quite broken and could not load packages properly.

### alpha 1.2.5 :
Trying to fix problems of vanilla plugin. (part 1) Fix all of the problems (and also left some poorly fixed problems that *might* be fixed in the future)(part 2). Fix the part of where the frame of plugin vanilla is white (part 3). Moved the resource file into the jar file game.jar (can work), renamed it to assets.(last part).

### alpha 1.2.6 :
Fix some stuffs and made the <code>LClient</code> <code>LServer</code> work. (part 1) Fix the problem that the server and client recieves useless nulls, also redone the templates to match what I expected. (part 2) Tested the local server and client, change the protocol to UDP for simplification; Made a testing command "test" and a working command "play", one for in-game and one for in the main menu. The UDP socket might be changed for
some higher reliability throw changing the protocol. (last part).

### alpha 1.2.7 :
Redone some small parts of compiling, tested some stuffs (part 1). Renamed the in-game cmd "test" to "time" and added the cmd "info" for checking what plugins are loaded; Redone the part where the plugins are loaded, now plugin names can be anything. (part 2). Fixed some class loading and made the commands of the <code>LServerCMDSolver</code> can have parameters; Turned <code>runnable</code> classes into <code>Thread</code> classes, decreasing the amount of lines of code needed to start a thread. (part 3).

### TODOS :

1. Make some simple in-game commands.
2. Add some more pages on fandom wiki (see the description of this repo.)
