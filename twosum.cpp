// substract one number and check if the other one is also in the map
// time complexity: O(n)


class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target)
	{
		unordered_map<int, int> given;
		vector<int> result;

		for (int i = 0; i<nums.size(); i++)
		{
			// given[nums[i]]=i; cannot put here, or it will add up two same number  

			auto second_num = target - nums[i];
			if (given.find(second_num) != given.end())
			{
				result.push_back(given[second_num]);
				result.push_back(i);
				return result;
			}

			given[nums[i]] = i;
			// value as search key, index as mapping value

		}
		return result;
	}
};

