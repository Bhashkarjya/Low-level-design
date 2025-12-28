## Media Player Play / Pause State

### Goal
Implement a media player whose behavior changes based on whether it is playing or paused.

### States (Only 2)

#### 1. Playing

#### 2. Paused

### Actions

The player exposes just two operations:
1. play()
2. pause()

### Expected Behavior
1. Paused	▶️ Starts playing → Playing	❌ Already paused
2. Playing	❌ Already playing	⏸ Pauses → Paused