package tests.homeworks;

import libs.CoreTestCase;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.MyListPageObject;
import ui.NavigationUI;
import ui.SearchPageObject;

public class ComplexScripts extends CoreTestCase {
    @Test
    public void testSavedOfTwoArticles() throws InterruptedException {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Android");
        SearchPageObject.clickByArticleWithSubstring("Android (operating system)");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "os_lists";
        ArticlePageObject.addArticleToMyNewList(name_of_folder);
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Microsoft Windows");
        SearchPageObject.clickByArticleWithSubstring("Microsoft Windows");
        ArticlePageObject.waitForTitleElement();
        String second_article_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyList();

        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(first_article_title);
        MyListPageObject.clickByArticleTitleInFolder("Microsoft Windows");
        String actual_title_article = ArticlePageObject.getArticleTitle();
        assertEquals(
                "Article title have been wrong value after opened",
                second_article_title, actual_title_article);
        Thread.sleep(500);
    }

    @Test
    public void testAssertTitle() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Android");
        SearchPageObject.clickByArticleWithSubstring("Android (operating system)");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.assertArticleTitle("Android (operating system)");
    }

    @Test
    public void testCheckResultsSearchByTitleAndDescription() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("BMW 3 Series");
        SearchPageObject.waitForElementByTitleAndDescription("BMW", "BMW");
    }
}
