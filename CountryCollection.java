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
    static Country[] countries = { new Country("�A�����J���O��", false), new Country("���ؐl�����a��", false),
            new Country("���{��", false), new Country("�h�C�c�A�M���a��", false), new Country("�t�����X���a��", false),
            new Country("�C�M���X", false), new Country("�C���h���a��", false), new Country("�u���W���A�M���a��", false),
            new Country("�C�^���A���a��", false), new Country("�J�i�_���a��", false), new Country("���V�A�A�M", false),
            new Country("�I�[�X�g�����A�A�M", false), new Country("�X�y�C������", false), new Country("��ؖ���", false),
            new Country("���L�V�R���O��", false), new Country("�g���R���a��", false), new Country("�C���h�l�V�A���a��", false),
            new Country("�I�����_����", false), new Country("�T�E�W�A���r�A����", false), new Country("�X�C�X�A�M", false),
            new Country("�|�[�����h���a��", false), new Country("�X�E�F�[�f������", false), new Country("�C�����E�C�X�������a��", false),
            new Country("���ؖ���", false), new Country("�x���M�[����"), new Country("�m���E�F�[����"), new Country("�A���[���`�����a��"),
            new Country("�i�C�W�F���A���a��"), new Country("�I�[�X�g���A���a��"), new Country("��A�t���J���a��"), new Country("�^�C����"),
            new Country("�A���u�񒷍��A�M����"), new Country("�R�����r�A���a��"), new Country("�}���[�V�A���a��"), new Country("�f���}�[�N����"),
            new Country("�A�C�������h���a��"), new Country("�V���K�|�[�����a��"), new Country("�t�B���s�����a��"), new Country("�C�X���G�����a��"),
            new Country("�x�l�Y�G���E�{���o�����a��"), new Country("���`"), new Country("�`�����a��"), new Country("�G�W�v�g���a��"),
            new Country("�t�B�������h���a��"), new Country("�M���V�����a��"), new Country("�`�F�R���a��"), new Country("�p�L�X�^�����a��"),
            new Country("�|���g�K�����a��"), new Country("���[�}�j�A���a��"), new Country("�C���N���a��"), new Country("�A���W�F���A���a��"),
            new Country("�y���[���a��"), new Country("�J�U�t�X�^�����a��"), new Country("�j���[�W�[�����h����"), new Country("�o���O���f�V�����a��"),
            new Country("�x�g�i���Љ��`���a��"), new Country("�J�^�[������"), new Country("�n���K���[���a��"), new Country("�N�E�F�[�g���a��"),
            new Country("�E�N���C�i���a��"), new Country("�����b�R����"), new Country("�X���o�L�A���a��"), new Country("�A���S�����a��"),
            new Country("�v�G���g���R"), new Country("�G�N�A�h�����a��"), new Country("�X�������J����Љ��`���a��"), new Country("�h�~�j�J���a��"),
            new Country("�L���[�o���a��"), new Country("�I�}�[����"), new Country("�K�[�i���a��"), new Country("�~�����}�[�A�M���a��"),
            new Country("�E�Y�x�L�X�^�����a��"), new Country("���N�Z���u���N�����"), new Country("�N���A�`�A���a��"), new Country("�X�[�_�����a��"),
            new Country("�x�����[�V���a��"), new Country("�u���K���A���a��"), new Country("�P�j�A���a��"), new Country("�A�[���o�C�W�������a��"),
            new Country("�X���x�j�A���a��"), new Country("�O�A�e�}�����a��"), new Country("�G�`�I�s�A�A�M���勤�a��"), new Country("�E���O�A�C�������a��"),
            new Country("�^���U�j�A�A�M���a��"), new Country("�`���j�W�A���a��"), new Country("�R�X�^���J���a��"), new Country("���g�A�j�A���a��"),
            new Country("�p�i�}���a��"), new Country("���o�m�����a��"), new Country("�Z���r�A���a��"), new Country("�g���N���j�X�^�����a��"),
            new Country("�R�[�g�W�|���[�����a��"), new Country("�J�����[�����a��"), new Country("�S��"), new Country("�R���S���勤�a��"),
            new Country("�o�[���[������"), new Country("�����_������"), new Country("���g�r�A���a��"), new Country("�U���r�A���a��"),
            new Country("�{���r�A��������") };

    public static void main(String[] args) {

        myframe = new JFrame("�����R���N�V����");
        myframe.setLayout(null);
        myframe.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        myframe.setVisible(true);
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        menu.add(createBtn("���j���[", Color.cyan, 48, 0, 0, 200, 200));
        JPanel menuToGacha = createBtn("�K�`��", Color.green, 32, 300, 300, 100, 100);
        menu.add(menuToGacha);
        JPanel menuToQuiz = createBtn("�N�C�Y", Color.blue, 32, 500, 300, 100, 100);
        menu.add(menuToQuiz);
        pointBtn = createBtn("�|�C���g" + point, Color.orange, 16, 300, 0, 100, 100);
        menu.add(pointBtn);
        zukanBtn = createBtn("�}��", Color.red, 32, 700, 300, 100, 100);
        menu.add(zukanBtn);
        bgImg = new JLabel(new ImageIcon(new ImageIcon("img/sekaichizu.jpg").getImage().getScaledInstance(WINDOW_WIDTH,
                WINDOW_HEIGHT, java.awt.Image.SCALE_FAST)));
        bgImg.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        menu.add(bgImg);

        zukan = new JPanel();
        zukan.setLayout(null);
        zukan.setBounds(0, 0, WINDOW_WIDTH, 1080);
        JPanel zukanToMenu = createBtn("�}��", Color.red, 32, 0, 0, 100, 100);
        zukan.add(zukanToMenu);
        JLabel[] countryImg = new JLabel[countries.length];
        JPanel[] countryNames = new JPanel[countries.length];

        gacha = new JPanel();
        gacha.setLayout(null);
        gacha.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        JPanel gachaToMenu = createBtn("�K�`��", Color.green, 32, 0, 0, 100, 100);
        gacha.add(gachaToMenu);

        quiz = new JPanel();
        quiz.setLayout(null);
        quiz.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        JPanel quizToMenu = createBtn("�N�C�Y", Color.blue, 32, 0, 0, 100, 100);
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
                JPanel nextPage = createBtn("����", Color.red, 16, 500, 0, 100, 100);
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
                JPanel prePage = createBtn("�O��", Color.blue, 16, 600, 0, 100, 100);
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
                    gachaLabel = new JLabel(countries[rand].name + "����肵���I");
                    gachaLabel.setHorizontalAlignment(JLabel.CENTER);
                    gachaLabel.setFont(new Font("���S�V�b�N", Font.BOLD, 24));
                    gachaLabel.setBounds((WINDOW_WIDTH - size) / 2, 500, 500, 100);

                    gacha.add(gachaLabel);
                    gacha.add(gachaCountry);
                    gacha.setVisible(true);
                } else {
                    JPanel dialog = createBtn("�|�C���g������܂���", Color.gray, 16, 300, 200, 500, 50);
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
                pointBtn = createBtn("�|�C���g" + point, Color.orange, 16, 300, 0, 100, 100);
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
                pointBtn = createBtn("�|�C���g" + point, Color.orange, 16, 300, 0, 100, 100);
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
                pointBtn = createBtn("�|�C���g" + point, Color.orange, 16, 300, 0, 100, 100);
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
            JPanel dialog = createBtn("�����I", Color.gray, 16, 300, 650, 500, 50);
            dialog.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    point++;
                    quiz.remove(dialog);
                    createQuiz();
                }
            });
            JPanel dialog2 = createBtn("�s�����I", Color.gray, 16, 300, 650, 500, 50);
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
        label.setFont(new Font("���S�V�b�N", Font.BOLD, fontSize));
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