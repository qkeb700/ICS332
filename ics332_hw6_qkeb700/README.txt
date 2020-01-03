Q1. heap allocates new chunks of RAM at the end of holes in memory because if the heap allocator did lower addresses then 480-byte chunk would be allocated at address 2112

Q2. I would say that the heap allocator uses worst fit because 80 byte could still go into the rest of 512 byte holes, but it went into 128 byte holes.

Q3. I would say that the hep allocator uses none of the abouve because it doesn't follow any of the three fits. 

Q4. The 400 byte chunk was allocated at address 2224
    The 100 byte chunk was allocated at address 3676
    The 10 byte chunk was allocated at address 2214
    The 10 byte chunk was allocated at address 2204