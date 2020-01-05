# foosOBS
Flexible foosball score keeper program compatible with OBS Studio

## Overview
foosOBS was written to update text files used by OBS Studio to display scores and game counts while live streaming foosball matches.  Almost every field displayed in foosOBS can be output to a file that OBS Studio can then read and display in a scene. 

foosOBS Main Screen:
<img align="left" width="850" height="630" src="https://github.com/hsgarn/foosOBS/blob/master/foosOBSscreen1.png">

OBS Studio scene utilizing foosOBS text files:
<img align="left" width="1920" height="1090" src="https://github.com/hsgarn/foosOBS/blob/master/foosOBSscreen2.png">

## Setup
foosOBS is a java program. You can download the source and export to a jar file. I do this in eclipse so am not sure how to do it at command line or in other ide's, though I'm sure google is your friend and will provide you with that information.  Windows will need to have at least Java 1.8 loaded and set to associate jar files with java. 

## Settings
If running foosOBS for the first time, it will create a config.properties file with the default properties in the folder in which the program is running. These properties contain the settings for the operating parameters, filenames and hot keys.

### Operating Parameters
foosOBS tries to make keeping track of a foosball match's progress as simple as possible.  To that end, there is a settings screen that contains parameters that affect how foosOBS will behave.  Click the Settings button on the main page to get to the settings screen.
<img align="left" width="640" height="480" src="https://github.com/hsgarn/foosOBS/blob/master/foosOBSSettings1.png"

Main Settings Page:
<img align="left" width="552" height="442" src="https://github.com/hsgarn/foosOBS/blob/master/foosOBSSettings2.png"

#### Points to Win
This is the number of points required to win a game.  This is only used if the Auto Increment Game checkbox is checked. Once a team's score reaches this number, it will reset to zero and increase the game counter for the team.  If the Announce Winner check box is set and the team has reached the number in the Games to Win parameter, then the Team's name will be written to the Match Winner file along with the text specified in the Winner Prefix and Winner Suffix parameters.  Points to Win is also utilized to determine if it is meatball (both teams 1 point away from winning score).

#### Max Win
The Max Win parameter is only used when the Win By parameter is greater than 1.  If a team has to win by more than 1 point, then Max Win is the maximum score a team can get and at that point it does not matter if they won by more than 1 point.

#### Win By
The Win By parameter is used to force a team to win by a specified number of points.  Default is 1 which means that a team only has to win by 1 point (normal game behavior).  Setting the parameter to 2 would require that a team win by two points.  If a team reaches the Points to Win value without being ahead by the Win By value, then the game continues until either a team wins by the Win By margin, or the Max Win value is reached.

