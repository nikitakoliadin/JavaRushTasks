package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {

    //    private static final String URL_FORMAT = "https://javarush.ru/testdata/big28data.html";
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> Vacancies = new ArrayList<>();

        try {
            int pageNumber = 0;
            Document document = null;

            while (true) {
                document = getDocument(searchString, pageNumber);

                if (document == null) {
                    break;
                }

                Elements vacancies = document.select("[data-qa=vacancy-serp__vacancy]");

                if (vacancies.size() == 0) {
                    break;
                }

                for (Element element : vacancies) {
                    if (element != null) {
                        Vacancy vac = new Vacancy();

                        Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                        String title = titleElement.text();

                        Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                        String salary = "";
                        if (salaryElement != null) {
                            salary = salaryElement.text();
                        }

                        vac.setTitle(title);
                        vac.setCompanyName(element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text());
                        vac.setSiteName("http://hh.ua/");
                        vac.setUrl(titleElement.attr("href"));
                        vac.setSalary(salary);
                        vac.setCity(element.select("[data-qa=vacancy-serp__vacancy-address]").first().text());

                        Vacancies.add(vac);
                    }
                }
                pageNumber++;
            }
        } catch (IOException ignore) {

        }

        return Vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);

        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                .timeout(5000)
                .referrer("none")
                .get();
    }
}