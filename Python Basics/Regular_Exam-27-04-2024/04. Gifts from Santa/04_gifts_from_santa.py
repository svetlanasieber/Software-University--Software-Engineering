def main():
    N = int(input())
    M = int(input())
    S = int(input())

    addresses = []

    for address in range(M, N - 1, -1):
        if address % 6 == 0:
            if address == S:
                break
            addresses.append(address)


    print(" ".join(map(str, addresses)))

if __name__ == "__main__":
    main()
