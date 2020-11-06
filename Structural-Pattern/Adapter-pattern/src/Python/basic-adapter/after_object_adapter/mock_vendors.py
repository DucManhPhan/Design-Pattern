from vendor import Vendor
from vend_adapter import VendAdapter

# wrap the Vender objects with the VendorAdapter
MOCKVENDORS = (
    VendAdapter(Vendor('Dough Factory', 1, 'Semolina Court')),
    VendAdapter(Vendor('Farm Produce', 14, 'Country Rd.')),
    VendAdapter(Vendor('Cocoa World', 53, 'Tropical Blvd'))
)