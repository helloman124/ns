#include <stdio.h>
#include <string.h>

int main() {
    char str[] = "Hello World";
    char str1[12], str2[12]; // Increased array size to accommodate null terminator
    int i, len;
    
    len = strlen(str);
    
    printf("After applying AND operation corresponding ASCII and its values:\n");
    for (i = 0; i < len; i++) {
        str1[i] = str[i] & 127;
        printf("%d = %c \n", str[i], str1[i]);
    }
    str1[len] = '\0'; // Null terminate the string
    printf("output string: %s\n", str1); // Changed %c to %s to print string
    
    printf("\nAfter applying XOR operation corresponding ASCII and its values:\n");
    for (i = 0; i < len; i++) {
        str2[i] = str[i] ^ 127;
        printf("%d = %c \n", str2[i], str2[i]);
    }
    str2[len] = '\0'; // Null terminate the string
    printf("output string: %s\n", str2); // Changed %c to %s to print string
    
    return 0;
}
