from abs_adapter import AbsAdapter


class VendAdapter(AbsAdapter):
    @property
    def name(self):
        return self.adaptee.name

    @property
    def address(self):
        return '{} {}'.format(
            self.adaptee.name,
            self.adaptee.street
        )