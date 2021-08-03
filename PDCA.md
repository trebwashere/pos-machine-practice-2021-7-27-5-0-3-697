PosV2 PDCA:

Function name: getItemInformation
P: 1 min
D: 2 min
C: Implementation took a longer time due to the looping and I would've preferred if the ItemInfo was an enum instead.
A: Maybe convert the ItemInfo into an enum since the values are mostly final values

Function name: getItemCount
P: 1 min
D: 1 min
C: I was already familiar with the syntax to use in getting the frequency so I did not encounter any delays with the implementation.
A: None.

Function name: getItems
P: 2 min
D: 5 min
C: Implementation took a longer time since I had to find a way to eliminate the duplicate barcodes.
A: I should familiarize myself more in different functions of ArrayLists

Function name: getItemSubtotal
P: 1 min
D: 1 min
C: There was no delay since it is basically just multiplying the quantity with the price
A: None

Function name: getFinalTotal
P: 2 min
D: 5 min
C: I had a slight delay since I had to re-familiarize myself with the Java libraries involving lambda usage and using the existing libraries to return the sum of the subtotal of all items.
A: I should familiarize myself more with the Collections library of Java and Functional Programming.

Function name: generateReceiptDetails
P: 2 min
D: 2 min
C: There was no difference since it is just combining the submethods which is getItemSubtotal and getFinalTotal and put them under the Receipt object.
A: None

Function name: formatReceipt
P: 2 min
D: 5 min
C: There was a difference since String.format is not returning an equal value with the assert test due to the line feed.
A: Maybe use a generic formatting approach so that all special functions are read the same

Function name: printReceipt
P: 1 min
D: 1 min
C: No difference between planning and implementing since it just calls the submethods and combine them all together.
A: None