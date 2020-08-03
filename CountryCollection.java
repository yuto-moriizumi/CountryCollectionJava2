import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CountryCollection {
    static JFrame myframe;
    static JPanel menu, zukan, zukanBtn, pointBtn, quiz, gacha;
    static int now = 0;
    static JLabel gachaCountry;
    static JLabel gachaLabel;
    static JLabel bgImg;
    static boolean isFirstZukan, isFirstGacha, isFirstQuiz;
    public static int point = 0;
    static int offset = 0;
    static JPanel[] selection = { new JPanel(), new JPanel(), new JPanel(), new JPanel() };
    static JLabel quizCountry = new JLabel();
    static final int WINDOW_WIDTH = 1024, WINDOW_HEIGHT = 768;
    static Country[] countries = { new Country("アメリカ合衆国", false), new Country("中華人民共和国", false),
            new Country("日本国", false), new Country("ドイツ連邦共和国", false), new Country("フランス共和国", false),
            new Country("イギリス", false), new Country("インド共和国", false), new Country("ブラジル連邦共和国", false),
            new Country("イタリア共和国", false), new Country("カナダ共和国", false), new Country("ロシア連邦", false),
            new Country("オーストラリア連邦", false), new Country("スペイン王国", false), new Country("大韓民国", false),
            new Country("メキシコ合衆国", false), new Country("トルコ共和国", false), new Country("インドネシア共和国", false),
            new Country("オランダ王国", false), new Country("サウジアラビア王国", false), new Country("スイス連邦", false),
            new Country("ポーランド共和国", false), new Country("スウェーデン王国", false), new Country("イラン・イスラム共和国", false),
            new Country("中華民国", false), new Country("ベルギー王国"), new Country("ノルウェー王国"), new Country("アルゼンチン共和国"),
            new Country("ナイジェリア共和国"), new Country("オーストリア共和国"), new Country("南アフリカ共和国"), new Country("タイ王国"),
            new Country("アラブ首長国連邦王国"), new Country("コロンビア共和国"), new Country("マレーシア共和国"), new Country("デンマーク王国"),
            new Country("アイルランド共和国"), new Country("シンガポール共和国"), new Country("フィリピン共和国"), new Country("イスラエル共和国"),
            new Country("ベネズエラ・ボリバル共和国"), new Country("香港"), new Country("チリ共和国"), new Country("エジプト共和国"),
            new Country("フィンランド共和国"), new Country("ギリシャ共和国"), new Country("チェコ共和国"), new Country("パキスタン共和国"),
            new Country("ポルトガル共和国"), new Country("ルーマニア共和国"), new Country("イラク共和国"), new Country("アルジェリア共和国"),
            new Country("ペルー共和国"), new Country("カザフスタン共和国"), new Country("ニュージーランド王国"), new Country("バングラデシュ共和国"),
            new Country("ベトナム社会主義共和国"), new Country("カタール王国"), new Country("ハンガリー共和国"), new Country("クウェート共和国"),
            new Country("ウクライナ共和国"), new Country("モロッコ王国"), new Country("スロバキア共和国"), new Country("アンゴラ共和国"),
            new Country("プエルトリコ"), new Country("エクアドル共和国"), new Country("スリランカ民主社会主義共和国"), new Country("ドミニカ共和国"),
            new Country("キューバ共和国"), new Country("オマーン国"), new Country("ガーナ共和国"), new Country("ミャンマー連邦共和国"),
            new Country("ウズベキスタン共和国"), new Country("ルクセンブルク大公国"), new Country("クロアチア共和国"), new Country("スーダン共和国"),
            new Country("ベラルーシ共和国"), new Country("ブルガリア共和国"), new Country("ケニア共和国"), new Country("アゼルバイジャン共和国"),
            new Country("スロベニア共和国"), new Country("グアテマラ共和国"), new Country("エチオピア連邦民主共和国"), new Country("ウルグアイ東方共和国"),
            new Country("タンザニア連邦共和国"), new Country("チュニジア共和国"), new Country("コスタリカ共和国"), new Country("リトアニア共和国"),
            new Country("パナマ共和国"), new Country("レバノン共和国"), new Country("セルビア共和国"), new Country("トルクメニスタン共和国"),
            new Country("コートジポワール共和国"), new Country("カメルーン共和国"), new Country("澳門"), new Country("コンゴ民主共和国"),
            new Country("バーレーン王国"), new Country("ヨルダン王国"), new Country("ラトビア共和国"), new Country("ザンビア共和国"),
            new Country("ボリビア多民族国") };

    public static void main(String[] args) {

        myframe = new JFrame("お国コレクション");
        myframe.setLayout(null);
        myframe.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        myframe.setVisible(true);
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        menu.add(createBtn("メニュー", Color.cyan, 48, 0, 0, 200, 200));
        JPanel menuToGacha = createBtn("ガチャ", Color.green, 32, 300, 300, 100, 100);
        menu.add(menuToGacha);
        JPanel menuToQuiz = createBtn("クイズ", Color.blue, 32, 500, 300, 100, 100);
        menu.add(menuToQuiz);
        pointBtn = createBtn("ポイント" + point, Color.orange, 16, 300, 0, 100, 100);
        menu.add(pointBtn);
        zukanBtn = createBtn("図鑑", Color.red, 32, 700, 300, 100, 100);
        menu.add(zukanBtn);
        bgImg = new JLabel(new ImageIcon(new ImageIcon("img/sekaichizu.jpg").getImage().getScaledInstance(WINDOW_WIDTH,
                WINDOW_HEIGHT, java.awt.Image.SCALE_FAST)));
        bgImg.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        menu.add(bgImg);

        zukan = new JPanel();
        zukan.setLayout(null);
        zukan.setBounds(0, 0, WINDOW_WIDTH, 1080);
        JPanel zukanToMenu = createBtn("図鑑", Color.red, 32, 0, 0, 100, 100);
        zukan.add(zukanToMenu);
        JLabel[] countryImg = new JLabel[countries.length];
        JPanel[] countryNames = new JPanel[countries.length];

        gacha = new JPanel();
        gacha.setLayout(null);
        gacha.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        JPanel gachaToMenu = createBtn("ガチャ", Color.green, 32, 0, 0, 100, 100);
        gacha.add(gachaToMenu);

        quiz = new JPanel();
        quiz.setLayout(null);
        quiz.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        JPanel quizToMenu = createBtn("クイズ", Color.blue, 32, 0, 0, 100, 100);
        quiz.add(quizToMenu);

        isFirstZukan = true;
        zukanBtn.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                menu.setVisible(false);
                if (isFirstZukan) {
                    isFirstZukan = false;
                } else {
                    for (int i = 0; i < 8; i++) {
                        zukan.remove(countryImg[i]);
                        zukan.remove(countryNames[i]);
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (countries[i].isOwn) {
                        countryImg[i] = new JLabel(new ImageIcon(new ImageIcon("img/" + i + ".jpg").getImage()
                                .getScaledInstance(180, 120, java.awt.Image.SCALE_FAST)));
                        countryImg[i].setBounds(100 + i % 4 * 200, 100 + (int) (i / 4) * 200, 180, 120);
                        zukan.add(countryImg[i]);
                        countryNames[i] = createBtn(countries[i + offset * 8].name, Color.cyan, 16, 100 + i % 4 * 200,
                                220 + (int) (i / 4) * 200, 180, 50);
                        zukan.add(countryNames[i]);
                    } else {
                        countryImg[i] = new JLabel(new ImageIcon(new ImageIcon("img/unknown.png").getImage()
                                .getScaledInstance(180, 120, java.awt.Image.SCALE_FAST)));
                        countryImg[i].setBounds(100 + i % 4 * 200, 100 + (int) (i / 4) * 200, 180, 120);
                        zukan.add(countryImg[i]);
                        countryNames[i] = createBtn("?????", Color.cyan, 16, 100 + i % 4 * 200,
                                220 + (int) (i / 4) * 200, 180, 50);
                        zukan.add(countryNames[i]);
                    }
                }
                JPanel nextPage = createBtn("次へ", Color.red, 16, 500, 0, 100, 100);
                nextPage.addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent e) {
                        if ((offset + 1) * 8 < countries.length) {
                            zukan.setVisible(false);
                            offset++;
                            for (int i = 0; i < 8; i++) {
                                zukan.remove(countryImg[i]);
                                zukan.remove(countryNames[i]);
                                if (i + offset * 8 < countries.length && countries[i + offset * 8].isOwn) {
                                    countryImg[i] = new JLabel(
                                            new ImageIcon(new ImageIcon("img/" + (i + offset * 8) + ".jpg").getImage()
                                                    .getScaledInstance(180, 120, java.awt.Image.SCALE_FAST)));
                                    countryImg[i].setBounds(100 + i % 4 * 200, 100 + (int) (i / 4) * 200, 180, 120);
                                    zukan.add(countryImg[i]);
                                    countryNames[i] = createBtn(countries[i + offset * 8].name, Color.cyan, 16,
                                            100 + i % 4 * 200, 220 + (int) (i / 4) * 200, 180, 50);
                                    zukan.add(countryNames[i]);
                                } else {
                                    countryImg[i] = new JLabel(new ImageIcon(new ImageIcon("img/unknown.png").getImage()
                                            .getScaledInstance(180, 120, java.awt.Image.SCALE_FAST)));
                                    countryImg[i].setBounds(100 + i % 4 * 200, 100 + (int) (i / 4) * 200, 180, 120);
                                    zukan.add(countryImg[i]);
                                    countryNames[i] = createBtn("?????", Color.cyan, 16, 100 + i % 4 * 200,
                                            220 + (int) (i / 4) * 200, 180, 50);
                                    zukan.add(countryNames[i]);
                                }
                            }
                            zukan.setVisible(true);
                            zukan.updateUI();
                        }
                    }
                });
                zukan.add(nextPage);
                JPanel prePage = createBtn("前へ", Color.blue, 16, 600, 0, 100, 100);
                prePage.addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent e) {
                        if (offset > 0) {
                            offset--;
                            for (int i = 0; i < 8; i++) {
                                zukan.remove(countryImg[i]);
                                zukan.remove(countryNames[i]);
                                if (i + offset * 8 < countries.length && countries[i + offset * 8].isOwn) {
                                    countryImg[i] = new JLabel(
                                            new ImageIcon(new ImageIcon("img/" + (i + offset * 8) + ".jpg").getImage()
                                                    .getScaledInstance(180, 120, java.awt.Image.SCALE_FAST)));
                                    countryImg[i].setBounds(100 + i % 4 * 200, 100 + (int) (i / 4) * 200, 180, 120);
                                    countryNames[i] = createBtn(countries[i + offset * 8].name, Color.cyan, 16,
                                            100 + i % 4 * 200, 220 + (int) (i / 4) * 200, 180, 50);
                                    zukan.add(countryImg[i]);
                                    zukan.add(countryNames[i]);
                                } else {
                                    countryImg[i] = new JLabel(new ImageIcon(new ImageIcon("img/unknown.png").getImage()
                                            .getScaledInstance(180, 120, java.awt.Image.SCALE_FAST)));
                                    countryImg[i].setBounds(100 + i % 4 * 200, 100 + (int) (i / 4) * 200, 180, 120);
                                    zukan.add(countryImg[i]);
                                    countryNames[i] = createBtn("?????", Color.cyan, 16, 100 + i % 4 * 200,
                                            220 + (int) (i / 4) * 200, 180, 50);
                                    zukan.add(countryNames[i]);
                                }
                            }
                        }
                    }
                });
                zukan.add(prePage);
                zukan.setVisible(true);
                zukan.updateUI();
            }
        });
        isFirstGacha = true;
        menuToGacha.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (point > 1) {
                    menu.setVisible(false);
                    if (isFirstGacha) {
                        isFirstGacha = false;
                    } else {
                        gacha.remove(gachaCountry);
                        gacha.remove(gachaLabel);
                    }
                    int rand = 0;

                    do {
                        rand = (int) (Math.random() * countries.length);
                    } while (countries[rand].isOwn);

                    countries[rand].isOwn = true;
                    point -= 2;
                    int size = 640;
                    gachaCountry = new JLabel(new ImageIcon(new ImageIcon("img/" + rand + ".jpg").getImage()
                            .getScaledInstance(640, 426, java.awt.Image.SCALE_FAST)));
                    gachaCountry.setBounds((WINDOW_WIDTH - size) / 2, (WINDOW_HEIGHT - size) / 3, size, size * 2 / 3);
                    gachaLabel = new JLabel(countries[rand].name + "を入手した！");
                    gachaLabel.setHorizontalAlignment(JLabel.CENTER);
                    gachaLabel.setFont(new Font("游ゴシック", Font.BOLD, 24));
                    gachaLabel.setBounds((WINDOW_WIDTH - size) / 2, 500, 500, 100);

                    gacha.add(gachaLabel);
                    gacha.add(gachaCountry);
                    gacha.setVisible(true);
                } else {
                    JPanel dialog = createBtn("ポイントが足りません", Color.gray, 16, 300, 200, 500, 50);
                    dialog.addMouseListener(new MouseAdapter() {
                        public void mouseReleased(MouseEvent e) {
                            menu.remove(dialog);
                        }
                    });
                    menu.add(dialog);
                    menu.remove(bgImg);
                    menu.add(bgImg);
                }
            }
        });
        isFirstQuiz = true;
        menuToQuiz.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                menu.setVisible(false);
                createQuiz();
                quiz.setVisible(true);
            }
        });
        zukanToMenu.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                zukan.setVisible(false);
                offset = 0;
                menu.remove(pointBtn);
                pointBtn = createBtn("ポイント" + point, Color.orange, 16, 300, 0, 100, 100);
                menu.add(pointBtn);
                menu.remove(bgImg);
                menu.add(bgImg);
                menu.setVisible(true);
            }
        });
        gachaToMenu.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                gacha.setVisible(false);
                menu.remove(pointBtn);
                pointBtn = createBtn("ポイント" + point, Color.orange, 16, 300, 0, 100, 100);
                menu.add(pointBtn);
                menu.remove(bgImg);
                menu.add(bgImg);
                menu.setVisible(true);
            }
        });
        quizToMenu.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                quiz.setVisible(false);
                menu.remove(pointBtn);
                pointBtn = createBtn("ポイント" + point, Color.orange, 16, 300, 0, 100, 100);
                menu.add(pointBtn);
                menu.remove(bgImg);
                menu.add(bgImg);
                menu.setVisible(true);
            }
        });

        zukan.setVisible(false);
        gacha.setVisible(false);
        quiz.setVisible(false);
        myframe.add(menu);
        myframe.add(zukan);
        myframe.add(gacha);
        myframe.add(quiz);

        while (true) {
            menu.updateUI();
            zukan.updateUI();
            gacha.updateUI();
            quiz.updateUI();
            myframe.repaint();
        }
    }

    static void createQuiz() {
        if (isFirstQuiz) {
            isFirstQuiz = false;
        } else {
            quiz.remove(quizCountry);
            for (int i = 0; i < 4; i++) {
                quiz.remove(selection[i]);
            }
        }
        int[] id = { -1, -1, -1, -1 };
        boolean isExist = false;
        for (int j = 0; j < id.length; j++) {
            int rand;
            do {
                rand = (int) (Math.random() * countries.length);
                isExist = false;
                for (int i = 0; i < id.length; i++) {
                    if (rand == id[i]) {
                        isExist = true;
                    }
                }
            } while (isExist);
            id[j] = rand;
        }
        int correctId = (int) (Math.random() * id.length);
        System.out.println(id[correctId]);

        for (int i = 0; i < id.length; i++) {
            selection[i] = createBtn(countries[id[i]].name, Color.blue, 16, 280 + 280 * (i % 2),
                    500 + 80 * (int) (i / 2), 200, 50);
            JPanel dialog = createBtn("正解！", Color.gray, 16, 300, 650, 500, 50);
            dialog.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    point++;
                    quiz.remove(dialog);
                    createQuiz();
                }
            });
            JPanel dialog2 = createBtn("不正解！", Color.gray, 16, 300, 650, 500, 50);
            dialog2.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    quiz.remove(dialog2);
                    createQuiz();
                }
            });
            if (id[i] == id[correctId])
                selection[i].addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent e) {
                        quiz.add(dialog);
                    }
                });
            else
                selection[i].addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent e) {
                        quiz.add(dialog2);
                    }
                });
            quiz.add(selection[i]);
        }
        quizCountry = new JLabel(new ImageIcon(new ImageIcon("img/" + id[correctId] + ".jpg").getImage()
                .getScaledInstance(640, 426, java.awt.Image.SCALE_FAST)));
        quizCountry.setBounds((WINDOW_WIDTH - 640) / 2, (WINDOW_HEIGHT - 640) / 3, 640, 426);
        quiz.add(quizCountry);
    }

    static JPanel createBtn(String str, Color color, int fontSize, int x, int y, int w, int h) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(str);
        label.setForeground(Color.white);
        panel.setBackground(color);
        label.setFont(new Font("游ゴシック", Font.BOLD, fontSize));
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.setBounds(x, y, w, h);
        panel.add(label);
        return panel;
    }

    static void sleep(long msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException ie) {
        }
    }
}

class Country {
    public String name;
    public boolean isOwn;

    public Country(String name, boolean isOwn) {
        this.name = name;
        this.isOwn = isOwn;
    }

    public Country(String name) {
        this(name, false);
    }
}