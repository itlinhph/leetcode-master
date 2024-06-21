def after_call_hook(func):
    def wrapper(self, *args, **kwargs):
        result = func(self, *args, **kwargs)
        if func.__name__ != "after_call":  # Prevent recursion
            self.after_call(func.__name__, *args, **kwargs)
        return result
    return wrapper

class HookMeta(type):
    def __new__(cls, name, bases, dct):
        for key, value in dct.items():
            if callable(value) and key != "after_call":
                dct[key] = after_call_hook(value)
        return super().__new__(cls, name, bases, dct)

class MyClass(metaclass=HookMeta):
    def after_call(self, method_name, *args, **kwargs):
        print(f"Method {method_name} called with args: {args} and kwargs: {kwargs}")

    def method1(self, x, y):
        print(f"Executing method1 with {x} and {y}")
        return x + y

    def method2(self, message):
        print(f"Executing method2 with message: {message}")
        return message.upper()

# Usage
obj = MyClass()
obj.method1(3, 4)
obj.method2("hello")