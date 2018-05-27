package com.example.leetcode.map;

import java.util.List;

/**
 * <p>
 * 648. 单词替换
 * </p>
 *
 * @author wangdejian
 * @since 2018/5/27
 */
public class ReplaceWorlds {
    /**
     * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
     * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
     * <p>
     * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     * <p>
     * 你需要输出替换之后的句子。
     * <p>
     * 示例 1:
     * <p>
     * 输入: dict(词典) = ["cat", "bat", "rat"]
     * sentence(句子) = "the cattle was rattled by the battery"
     * 输出: "the cat was rat by the bat"
     * 注:
     * <p>
     * 输入只包含小写字母。
     * 1 <= 字典单词数 <=1000
     * 1 <=  句中词语数 <= 1000
     * 1 <= 词根长度 <= 100
     * 1 <= 句中词语长度 <= 1000
     */
    public String replaceWords(List<String> dict, String sentence) {
        dict.sort((a, b) -> a.length() - b.length());
        String[] worlds = sentence.split("\\s+");

        for (int i = 0; i < worlds.length; i++) {
            String world = worlds[i];
            for (String root : dict) {
                if (world.startsWith(root)) {
                    worlds[i] = root;
                    break;
                }
            }
        }

        return String.join(" ", worlds);

    }
}
