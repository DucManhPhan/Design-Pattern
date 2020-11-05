from mock_customers import MOCKCUSTOMERS as CUSTOMERS
from mock_vendors import MOCKVENDORS as VENDORS

TYPE = 'vendors'

def main():
    if TYPE == 'customers':
        for cust in CUSTOMERS:
            print('Name: %s; Address: %s'
                % (cust.name, cust.address))
    elif TYPE == 'vendors':
        for vend in VENDORS:
            print('Name: %s; Address: %s %s' % (vend.name, vend.street, vend.street))
    else:
        raise ValueError('Incorrect type: ' + TYPE)


if __name__ == '__main__':
    main()