# foosOBS
FoosOBS is a flexible foosball score keeper program compatible with OBS Studio and also plays well with Elagto's Stream Deck products.

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

<img width="640" height="480" src="https://github.com/hsgarn/foosOBS/blob/master/foosOBSSettings1.png">

Main Settings Page:
<img width="552" height="442" src="https://github.com/hsgarn/foosOBS/blob/master/foosOBSSettings2.png">

#### Points to Win
This is the number of points required to win a game.  This is only used if the Auto Increment Game checkbox is checked. Once a team's score reaches this number, it will reset to zero and increase the game counter for the team.  If the Announce Winner check box is set and the team has reached the number in the Games to Win parameter, then the Team's name will be written to the Match Winner file along with the text specified in the Winner Prefix and Winner Suffix parameters.  Points to Win is also utilized to determine if it is meatball (both teams 1 point away from winning score).

#### Max Win
The Max Win parameter is only used when the Win By parameter is greater than 1.  If a team has to win by more than 1 point, then Max Win is the maximum score a team can get and at that point it does not matter if they won by more than 1 point.

#### Win By
The Win By parameter is used to force a team to win by a specified number of points.  Default is 1 which means that a team only has to win by 1 point (normal game behavior).  Setting the parameter to 2 would require that a team win by two points.  If a team reaches the Points to Win value without being ahead by the Win By value, then the game continues until either a team wins by the Win By margin, or the Max Win value is reached.

#### Games to Win
The Games to Win parameter is used to determine when a match is one.  Specify the number of games required to win the match.  Default is 2 for a 2 out of 3 match.  Use 3 for a 3 out of 5 match. etc.

#### Max Time Outs
The Max Time Outs parameter is used to set how many time outs each team has.  The default is 2.

#### Team 1 Last Scored
This parameter defines the text that will be put in the Last Scored text file when Team 1 scores.  The default value is "<--- Last Scored".

#### Team 2 Last Scored
This parameter defines the text that will be put in the Last Scored text file when Team 2 scores.  The default value is "Last Scored --->".

#### Clear Last Scored
This parameter defines the text that will be put in the Last Scored text file when neither team has scored (after the Reset All button is clicked or a score is reduced by the - button).

#### Team Name Separator
This parameter is used to set the character used to separate the forward's name from the goalie's name for each team.  The default character is /.  Everything prior to this character in the Team Name field is the forward's name and everything after this character is the goalie's name.  This allows the program to know how to switch the names if the forward and goalie swap places.

#### Shot Time
This is the time allowed to shoot the ball from the forward 3 rod or the goalie area in seconds.  The default is 15 seconds.

#### Pass Time
This is the time allowed to pass the ball from the 5 row to the 3 row in seconds.  The default is 10 seconds.

#### Time Out Time
This is the time allowed for a time out in seconds.  The default is 30 seconds.

#### Game Time
This is the time allowed between games in seconds.  The default is 90 seconds.

#### Recall Time (min)
This is the number of minutes a player may be on recall before forfeiting the match.  The default is 10 minutes.

#### Auto Increment Game checkbox
When checked, the game count for the team that just scored will be automatically incremented when their score is incremented and reaches the number of points required to win a game.

#### Announce Winner checkbox
When checked, the Match Winner file will be populated with the winning team name (prefixed by the Winner Prefix parameter and suffixed by the Winner Suffix parameter) when the game count for a team reaches the Games to Win parameter value.  Use the Reset Scores or Reset All buttons to clear the Match Winner file for the next match.

#### Announce Meatball checkbox
When checked, the Meatball file will be populated with the text in the Announce Meatball parameter when both teams' scores are one point away from winning.  Once the score changes, the text in the Meatball file will be automatically cleared.

#### Show Time Outs Used
When checked, the program will put the number of time outs remaining for each team in the Time Out files.  When unchecked, the program will put the number of time outs used for each team in the Time Out Files. Yes, this is backwards and I will fix this the next time I am in the code.

#### Auto Capitalize Names
When checked, the program will automatically capitalize the first letter of each team's player's names.  If not checked, the team names are left as entered.

### FileNames
FoosOBS writes out most of it's data to text files so that it can be read by programs such as OBS Studio and displayed in a live video stream.  The names of these files are configurable if the default names do not suit you.  FoosOBS also allows you to run more than one table at a time.  It does this by prefixing each file with the table name.  To get to the filenames configuration, click on the Files... button on the Settings window:

<img align="left" width="552" height="442" src="https://github.com/hsgarn/foosOBS/blob/master/foosOBSSettings3.png">

<img align="left" width="502" height="302" src="https://github.com/hsgarn/foosOBS/blob/master/foosOBSSettings5.png">

Below are the file names that can be configured:

#### Team 1
This is the filename for Team 1's name(s). Default filename is team1.txt.

#### Team 2
This is the filename for Team 2's name(s). Default filename is team2.txt.

#### Game Count 1
This is the filename for Team 1's game count. Default filename is gamecount1.txt.

#### Game Count 2
This is the filename for Team 2's game count. Default filename is gamecount2.txt.

#### Score 1
This is the filename for Team 1's score. Default filename is score1.txt.

#### Score 2
This is the filename for Team 2's score. Default filename is score2.txt.

#### Time Out 1
This is the filename for Team 1's time outs used or remaining depending the Show Time Outs Used checkbox. Default filename is timeout1.txt.

#### Time Out 2
This is the filename for Team 2's time outs used or remaining depending the Show Time Outs Used checkbox. Default filename is timeout2.txt.

#### Reset 1
This is the filename for Team 1's Reset flag.  Default filename is reset1.txt.

#### Reset 2
This is the filename for Team 2's Reset flag.  Default filename is reset2.txt.

#### Warn 1
This is the filename for Team 1's Reset Warning flag.  Default filename is warn1.txt.

#### Warn 2
This is the filename for Team 2's Reset Warning flag.  Default filename is warn2.txt.

#### Tournament
This is the filename of a freeform text field that can be used for the name of the tournament or venue.  Default filename is tournament.txt.

#### Event
This is the filename of a freeform text field that can be used for the name of the event being played (i.e. DYP, Open Singles, etc).  Default filename is event.txt.

#### Time Remaining
This is the filename for the Time Remaining on the current timer.  Default filename is timeremaining.txt.

#### Timer
This is the filename that holds the name of the current timer that is running (Shot, Pass, Game, Timeout, Recall). Default filename is timerinuse.txt.

#### Match Winner
This is the filename that holds the Winner Prefix, Team's Name and Winner Suffix of the team that won the match.  Default filename is matchwinner.txt.

#### Meatball
This is the filename that holds the Meatball text when a game is tied just prior to the final point.  Default filename is meatball.txt.

#### Last Scored
This is the filename that holds the indicator for which team scored last.  Default filename is lastscored.txt.

#### Save
Click the save button to save any filename changes made.

#### Cancel
Click the cancel button to discard any filename changes made.

#### Restore Defaults
Click the Restore Defaults button to restore the default filenames.

### Hot Keys
FoosOBS uses buttons to do various functions such as increase or decrease scores, switch sides, reset game counts, start timers, etc.  Each button can have a Hot Key assigned to it.  Pressing ALT plus the assigned Hot Key for the button will function just like pressing the actual button.  The hot keys can be used in Stream Deck commands to make operating FoosOBS a simple push button affair.

<img align="left" width="552" height="442" src="https://github.com/hsgarn/foosOBS/blob/master/foosOBSSettings4.png">

<img align="left" width="802" height="442" src="https://github.com/hsgarn/foosOBS/blob/master/foosOBSSettings6.png">

#### Clear(Tournament)
Assigns the hot key for the Clear Tournament button.  Default hot key is unassigned.

#### Clear(Event)
Assigns the hot key for the Clear Event button.  Default hot key is unassigned.

#### Reset(Team 1)
Assigns the hot key for the Reset button for Team 1.  Default hot key is z.

#### Reset(Team 2)
Assigns the hot key for the Reset button for Team 2.  Default hot key is ,.

#### Warn(Team 1)
Assigns the hot key for the Warn button for Team 1. Default hot key is x.

#### Warn(Team 2)
Assigns the hot key for the Warn button for Team 2. Default hot key is ..

#### Team Names
##### Clear(Team 1)
Assigns the hot key for the Clear button for Team 1's name. Default hot key is unassigned.

##### Clear(Team 2)
Assigns the hot key for the Clear button for Team 2's name. Default hot key is unassigned.

##### Switch(Team 1)
Assigns the hot key to Switch Team 1 and Team 2's names. Default hot key is t.

##### Switch(Team 2)
Assigns the hot key for the Switch button for Team 2's names. Default hot key is m.

#### Scores
##### -(Team 1)
Assigns the hot key for the - button for Team 1's score. Default hot key is unassigned.

##### -(Team 2)
Assigns the hot key for the - button for Team 2's score. Default hot key is unassigned.

##### +(Team 1)
Assigns the hot key for the + button to increase Team 1's score. Default hot key is 1.

##### +(Team 2)
Assigns the hot key for the + button to increase Team 2's score. Default hot key is 2.

##### Switch
Assigns the hot key to Switch Team 1 and Team 2's scores.  Default hot key is e.

#### Game Counts
##### -(Team 1)
Assigns the hot key for the - button for Team 1's score. Default hot key is unassigned.

##### -(Team 2)
Assigns the hot key for the - button for Team 2's score. Default hot key is unassigned.

##### +(Team 1)
Assigns the hot key for the + button to increase Team 1's game count. Default hot key is 5.

##### +(Team 2)
Assigns the hot key for the + button to increase Team 2's game count. Default hot key is 6.

##### Switch
#### Time Outs
##### Return TO(Team 1)
##### Use TO(Team 1)
##### Return TO(Team 2)
##### Use TO(Team 2)
##### Switch
#### Switch Sides
#### Reset Game Counts
#### Reset Scores
#### Reset Time Outs
#### Reset Reset/Warn
#### Reset All
#### Timers
##### Start(Shot)
##### Start(Pass)
##### Start(Time Out)
##### Start(Game)
##### Start(Recall)
#### Select Path
#### Set Path
#### Fetch Data
#### Save All
#### Settings

#### Save
Click the save button to save any hot key changes made.

#### Cancel
Click the cancel button to discard any hot keye changes made.

#### Restore Defaults
Click the Restore Defaults button to restore the default hot keys.



