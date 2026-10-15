# Решение в лоб
class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
       i = 0
        while i < len(nums):
            j = i + 1
            while j < len(nums):
                if nums[i] + nums[j] == target:
                    return [i, j]
                j += 1
            i += 1
<img width="1917" height="947" alt="Снимок экрана 2026-10-15 224615" src="https://github.com/user-attachments/assets/e1bdbc1b-895a-4e12-b554-c2884a0f8713" />
# Runtime 2956 ms, Memory 19,61 mb, Временная сложность: O(n²), Пространственная сложность: O(1)

# Решение через HashMap
class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
     hash_map = {}
        for i, num in enumerate(nums):
            if target - num in hash_map:
                return [hash_map[target - num], i]
            hash_map[num] = i
        return []
  <img width="1917" height="957" alt="Снимок экрана 2026-10-15 224653" src="https://github.com/user-attachments/assets/9b7b4fc5-fdc0-443e-8aad-f56d76ecc7fb" />

# Runtime 1 ms, Memory 20,44 mb, Временная сложность: O(n), Пространственная сложность: O(n)

# При решении в лоб два цикла перебирают все пары чисел. На больших тестах LeetCode работает медленно.
# В решении с HashMap проходим массив один раз, для каждого числа ищем target - num в словаре. Работает быстро
# HashMap выигрывает, потому что делает один проход вместо двух вложенных. Чем больше массив, тем заметнее разница, т.к. O(n²) растёт квадратично, а O(n) линейно.

# Решение в лоб от агента
class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        n = len(nums)

        for i in range(n):
            for j in range(i + 1, n):
                if nums[i] + nums[j] == target:
                    return [i, j]
<img width="1917" height="952" alt="Снимок экрана 2026-10-15 224038" src="https://github.com/user-attachments/assets/00eb13dd-0a59-410b-8b67-9c84c0b93b0b" />
# Runtime 1609 ms, Memory 19,6 mb, Временная сложность: O(n²), Пространственная сложность: O(1)

# Решение через HashMap от агента
class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        seen = {}

        for i, num in enumerate(nums):
            complement = target - num

            if complement in seen:
                return [seen[complement], i]

            seen[num] = i
<img width="1917" height="952" alt="Снимок экрана 2026-10-15 224245" src="https://github.com/user-attachments/assets/255232f1-efca-49c4-98b5-c9c64b6dcf45" />
# Runtime 0 ms, Memory 20,34 mb, Временная сложность: O(n), Пространственная сложность: O(n)

# В решениях, предложенных агентом, ошибок обнаружено не было, алгоритмы составлены корректно.
# У агента получилось написать решения, которые по скорости оказались более выигрышными.
