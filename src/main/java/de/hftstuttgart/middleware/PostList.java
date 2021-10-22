package de.hftstuttgart.middleware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostList {
    private static Map<Integer, Post> posts;

    PostList() {
        posts = new HashMap<>();
    }

    public ArrayList<Post> getAll() {
        return new ArrayList<Post>(posts.values());
    }

    public String getAllFormatted() {
        StringBuilder allToShow = new StringBuilder();
        if (posts.size() == 0) {
            return "Nothing here yet";
        } else {
            allToShow.append("<ul>");
            posts.forEach((id, post) -> {
                allToShow.append("<li>").append(post.getContent()).append("</li>");

            });
            allToShow.append("</ul>");
        }
        return allToShow.toString();
    }

    public Post addPost(Post newPost) {
        System.out.println("newPost:" + newPost.getID() + " " + newPost.getContent() + "allePosts: " + posts);
        posts.put(newPost.getID(), newPost);
        return newPost;
    }

    public void updatePost(Post newPost) {
        posts.get(newPost.getID()).setContent(newPost.getContent());
    }

    public void deletePost(Integer IDtoDelete) {
        posts.get(IDtoDelete);
        posts.remove(IDtoDelete);
    }
}
