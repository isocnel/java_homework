# Решение Агента
```python
class Solution:
    def isValid(self, s: str) -> bool:
        # словарь: закрывающая -> соответствующая открывающая
        pairs = {')': '(', ']': '[', '}': '{'}
        stack: list[str] = []

        for ch in s:
            if ch not in pairs:          # открывающая
                stack.append(ch)
            elif not stack or stack.pop() != pairs[ch]:
                # пусто ИЛИ вершина не та — сразу False
                return False

        return not stack                  # пустой стек == True


# --- проверки ---
if __name__ == "__main__":
    sol = Solution()
    for s in ["()", "()[]{}", "(]", "([])", "([)]", "{[]}", "(", ")"]:
        print(f"{s!r:10} -> {sol.isValid(s)}")
```

<img width="1919" height="950" alt="image" src="https://github.com/user-attachments/assets/372459f8-c6d7-4a3d-b596-9c06978a7d67" />
Решение использует стек чтобы отслеживать открытые скобки. Открывающие мы кладем в стек а при встрече закрывающей проверяем совпадает ли она с последней открытой и удаляем её.
В конце стек должен остаться пустым.
Сложность O(n) по времени так как мы проходим строку один раз а стек тут нужен потому что последняя открытая скобка всегда закрывается первой.

# Собственное решение
```python
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for ch in s:
            if ch in "([{":
                stack.append(ch)
            else:
                # закрывающая скобка, проверяем пару
                if not stack or not self.is_pair(stack[-1], ch):
                    return False
                stack.pop()

        # в конце все скобки должны закрыться
        return len(stack) == 0

    def is_pair(self, open_ch: str, close_ch: str) -> bool:
        if open_ch == '(' and close_ch == ')':
            return True
        if open_ch == '[' and close_ch == ']':
            return True
        if open_ch == '{' and close_ch == '}':
            return True
        return False


if __name__ == "__main__":
    sol = Solution()
    tests = [
        ("()", True),
        ("()[]{}", True),
        ("(]", False),
        ("([])", True),
        ("([)]", False),
        ("{[]}", True),
        ("(", False),
        (")", False),
    ]
    for s, expected in tests:
        got = sol.isValid(s)
        print(f"{s!r:10} -> {got}  (ожидалось {expected})  {'OK' if got == expected else 'FAIL'}")
```

<img width="1919" height="948" alt="image" src="https://github.com/user-attachments/assets/278c4623-4d31-40bf-866a-991845a6cca6" />
Это решение работает за O(n) по времени так как мы проходим строку ровно один раз. По памяти тоже O(n) потому что в худшем случае все скобки окажутся открывающими и забьют весь стек.
Здесь используется стек так как закрывающая скобка всегда относится к самой последней открытой.
Это и есть принцип LIFO когда последним пришел первым вышел.
