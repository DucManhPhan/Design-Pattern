from mock_vendors import MOCKVENDORS
CUSTOMERS = MOCKVENDORS

def main():
    for cust in CUSTOMERS:
        print('Name: %s; Address: %s' %
                (cust.name, cust.address))

if __name__ == '__main__':
    main()