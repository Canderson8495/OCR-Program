import sys
from googletrans import Translator
translator = Translator()
a = translator.translate(sys.argv[1])
print(a.text)
