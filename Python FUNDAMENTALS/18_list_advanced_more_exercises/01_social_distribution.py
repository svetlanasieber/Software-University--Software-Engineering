nums = list(map(int, input().split(", ")))
min_wealth = int(input())
is_equal_distribution = True

for index, num in enumerate(nums):
    if sum(nums) < len(nums) * min_wealth:
        is_equal_distribution = False
        break
    else:
        if num < min_wealth:
            max_num = max(nums)
            max_num_index = nums.index(max_num)
            if max_num - min_wealth >= min_wealth - num:
                nums[max_num_index] -= min_wealth - num
                nums[index] += min_wealth - num
        is_equal_distribution = True

print(f"{nums}" if is_equal_distribution else "No equal distribution possible")
