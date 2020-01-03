Exercise #1

a. 26596
b. 4348
c. 14294
d. 63500
e. 10242 because 10242/2024 = 5 which is page number, but the page doesn't have a frame. therefore, it will generate an error, page fault.

Exercise #2

a. 16 pages = 2^4 pages, 4096 bytes per page = 2^12 bytes per page. Therefore, 2^4+12 = 2^16 of logical address. 16 bits are required in the logical address. 

b. 2^12 bytes per page and 2^3 frames... Therefore, 2^12+3 = 2^15 of physical address. 15 bits are required in the physical address.

Exercise #3

a. 2^64 logical address space / 2*2^10 page/fram size =2^53 entries are in there.

b. 2^2 * 2^30 physical address space / 2^11 page/fram size = 2^21 entries are in there.

Exercise #4

a. 2^44 logical address / 2^6 * 2^10 page size = 2^28 pages

b. 2^16 page size / 2^2 bytes per page = 2^14 entries per page
   44(logical address) - 16(page size) - 14(outer page table) = 14(inner page table)






