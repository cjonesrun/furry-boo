a crack an an enigma machine implementation.

emulators;
http://enigma.louisedade.co.uk/enigma.html
http://enigmaco.de/enigma/enigma.html


see: https://github.com/johnflan/JavaEnigma

basics:

https://en.wikipedia.org/wiki/Enigma_rotor_details

3 of 5 rotors to be used.

each rotor has a configurable turn-over position(s) which rolls the next rotor

a plug board can be used to swap character on the way in/out

machine sequence is as follows:

key-press
step-rotors
plugboard-in
rotors R,M,L
reflector
rotors L,M,R
plugboard-out
read-output

EnigmaMachine
Rotor
PlugBoard
MachineBuilder


