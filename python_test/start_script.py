import importlib
import sys

if __name__ == "__main__":
    scriptName = sys.argv[1]
    module = importlib.import_module(scriptName)
    function = getattr(module, 'test_stript')
    function()
