| ***test case*** | ***test*** |
|-----------------|------------|
| empty list      | return 0   |
| one item        | return 1   |
| test two items many order ["a", "a", "b", "a", "b", "b"] | return 2 |
| add null to list | return 1 |
| list is null | throw NullPointerException |
| huge list [5, 6, 50, 60, 70, 90, 5, 100, 500, 1000, 0, 967, 90, 60, 2130, 888, 888, 888, 888, 888, 888, 907, 567, 111111] | return 16 |
| multiple type [2, 45, "a", "a", "b", "45"] | return 5 |
