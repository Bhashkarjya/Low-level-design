## Text Editor Character Rendering

### Goal

Build a text editor engine that efficiently renders millions of characters by sharing common character data instead of duplicating it.

### Problem Statement

1. You are implementing a text editor (like a very simplified Word/Google Docs engine). 
2. A document contains millions of characters, but:
   1. Many characters repeat (a, b, c, etc.)
   2. Characters share the same font properties 
3. If you create a new object for every character, memory usage becomes very high. 
4. Your task is to optimize memory usage using the Flyweight design pattern.


### Requirements

1. Characters with the same intrinsic state must be shared 
2. The editor should request characters through a factory 
3. No client code should directly create character objects 
4. Extrinsic state must not be stored inside the flyweight 
5. Memory usage must scale with unique characters, not total characters