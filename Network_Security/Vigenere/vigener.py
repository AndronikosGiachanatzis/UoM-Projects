from string import ascii_uppercase
from time import time


def encrypt(plaintext, key):
    key_length = len(key)
    key_as_int = [ord(i) for i in key]
    plaintext_int = [ord(i) for i in plaintext]
    ciphertext = ''
    for i in range(len(plaintext_int)):
        value = (plaintext_int[i] + key_as_int[i % key_length]) % 26
        ciphertext += chr(value + 65)
    return ciphertext


def main():
    ciphertext = "VIEOEGMOCIGOHHJGBALOTMRJBHUMPXRJKQAMMBZAZKLMROROMQRAAUMNFWUGKXRNGKKUCTXKXJLXGNXAFWQC" \
                 "HLBIAJLJVVQSHLVBVSXQZBUIKSGBBUEUELFZNXPKNXXZLTYEMBVIIGBFRJYKUIFSFGGXUWAUMZFZTKMNYIGNX" \
                 "VZOTKLNSWBQBMZVGNXCEBRXGYK"
    plaintext = "CONGRATULATIONSYOUSUCEEDINDECRYPTINGTHISMESSAGEITWASNOTTOOHARDAFTERALLKEEPUPTHEGOODWORK" \
                "ANDSPENDMORETIMEWITHCRYPTOOLANDSTUDYCAREFULLYTHEAVAILABLEBOOKSANDDONOTFORGETTHATHEBIGGEST" \
                "BOOKISINTHEINTERNET"

    c_part = "VIEOEG"
    p_part = "CONGRA"
    key = ""

    start_time = time()
    iterations = 0
    print("START ATTACK\n")
    for i in range(len(c_part)):
        for a in ascii_uppercase:
            iterations += 1
            if encrypt(p_part[i], a) == c_part[i]:
                print(" [+] letter", i+1,  "found: ", a)
                key += a
                break

    print("\n[+] key found")
    print("\t validating key...")
    if encrypt(plaintext, key) == ciphertext:
        print("[+] key OK")
    else:
        print("[-] WRONG KEY")

    end_time = time()
    print("ATTACK FINISHED")

    print("\nResults: ")
    print("\tkey:", key)
    running_time = end_time-start_time
    print("\tIterations needed: ", iterations)
    print("\t"+ str(running_time), "seconds")


if __name__ == "__main__":
    main()
