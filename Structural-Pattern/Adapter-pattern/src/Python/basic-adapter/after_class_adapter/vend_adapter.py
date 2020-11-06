from customer import Customer
from vendor import Vendor

class VendorAdapter(Vendor, Customer):
    def __init__(self, *args, **kargs):
        super().__init__(*args, **kargs)

    @property
    def address(self):
        return '{} {}'.format(
            self.number, self.street
        )
