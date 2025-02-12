#0ms REGEX

class Solution:
    def isNumber(self, s: str) -> bool:
        engine = re.compile(r"^[+-]?((\d+\.?\d*)|(\d*\.?\d+))([eE][+-]?\d+)?$")
        return bool(engine.match(s.strip(" ")))
