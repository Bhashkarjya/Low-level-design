## Home Theater Control System
### Goal

Provide a simple, unified interface to operate a complex subsystem of home theater components.

## Problem Statement

1. You are building software for a smart home theater system. 
2. The system internally consists of multiple independent subsystems:
   1. DVD Player 
   2. Projector 
   3. Sound System 
   4. Lights

3. Each subsystem has its own API and must be operated in a specific sequence to:
   1. Start watching a movie 
   2. Stop watching a movie

4. The client should not need to understand or coordinate these subsystems.