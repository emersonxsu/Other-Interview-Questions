vector<vector<string>> bucketAnagrams(vector<string> &strs) {
	vector<string> res;
	unordered_map<string,vector<string>> map;
	for(string s:strs){ 
		//sort every string and store groups of strings that are anagrams in a map
		string tmp = s;
		sort(tmp.begin(), tmp.end());
		map[tmp].push_back(s);
	}
	int i = 0;
	for(auto m:map) { // find all anagrams
		if(m.second.size() > 1)
		res[i++].push_back(m.second);
	}
	return res;
}