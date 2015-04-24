package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class TempVSPanel extends JPanel{
	private JTextField txtPgamenum;
	private JTextField txtPminute;
	private JTextField txtPscorefield;
	private JTextField txtPassistancefield;
	private JTextField txtPreboundfield;
	private JTextField txtPhitnum;
	private JTextField txtPprate;
	private JTextField txtPfreethrowrate;
	private JTextField txtPsteal;
	private JTextField txtPblock;
	private JTextField txtPturnover;
	private JTextField txtPfoul;
	private JTextField txtAgamenum;
	private JTextField txtAminute;
	private JTextField txtAscorefield;
	private JTextField txtAassistancefield;
	private JTextField txtAreboundfield;
	private JTextField txtAhitnum;
	private JTextField txtAprate;
	private JTextField txtAfreethrowrate;
	private JTextField txtAsteal;
	private JTextField txtAblock;
	private JTextField txtAturnover;
	private JTextField txtAfoul;

	public TempVSPanel(){
		this.setBounds(0, 0, 1000, 480);
		this.setVisible(true);
		this.setLayout(null);
		
		JLabel namelbl = new JLabel("姓名");
		namelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		namelbl.setBounds(0, 0, 450, 35);
		add(namelbl);
		
		JLabel vslbl = new JLabel("VS");
		vslbl.setHorizontalAlignment(SwingConstants.CENTER);
		vslbl.setBounds(450, 0, 100, 50);
		add(vslbl);
		
		JLabel nAtlbl = new JLabel("号码/球队");
		nAtlbl.setHorizontalAlignment(SwingConstants.RIGHT);
		nAtlbl.setBounds(0, 35, 450, 15);
		add(nAtlbl);
		
		JLabel nbaAvelbl = new JLabel("NBA联盟平均数据");
		nbaAvelbl.setBounds(550, 0, 450, 35);
		add(nbaAvelbl);
		
		JLabel seasonDatalbl= new JLabel("赛季数据");
		seasonDatalbl.setHorizontalAlignment(SwingConstants.CENTER);
		seasonDatalbl.setBounds(0, 50, 1000, 20);
		add(seasonDatalbl);
		
		JLabel gameNumlbl = new JLabel("参赛场数");
		gameNumlbl.setHorizontalAlignment(SwingConstants.CENTER);
		gameNumlbl.setBounds(425, 70, 150, 34);
		add(gameNumlbl);
		
		JLabel minutelbl = new JLabel("分钟");
		minutelbl.setHorizontalAlignment(SwingConstants.CENTER);
		minutelbl.setBounds(425, 104, 150, 34);
		add(minutelbl);
		
		JLabel scoreFieldlbl = new JLabel("场均得分");
		scoreFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		scoreFieldlbl.setBounds(425, 138, 150, 34);
		add(scoreFieldlbl);
		
		JLabel assistanceFieldlbl = new JLabel("场均助攻");
		assistanceFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		assistanceFieldlbl.setBounds(425, 172, 150, 34);
		add(assistanceFieldlbl);
		
		JLabel reboundFieldlbl = new JLabel("场均篮板");
		reboundFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		reboundFieldlbl.setBounds(425, 206, 150, 34);
		add(reboundFieldlbl);
		
		JLabel hitlbl = new JLabel("投篮命中数");
		hitlbl.setHorizontalAlignment(SwingConstants.CENTER);
		hitlbl.setBounds(425, 240, 150, 34);
		add(hitlbl);
		
		JLabel tpHitRatelbl = new JLabel("三分命中率");
		tpHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		tpHitRatelbl.setBounds(425, 274, 150, 34);
		add(tpHitRatelbl);
		
		JLabel ftHitRatelbl = new JLabel("罚球命中率");
		ftHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		ftHitRatelbl.setBounds(425, 308, 150, 34);
		add(ftHitRatelbl);
		
		JLabel stealFieldlbl = new JLabel("场均抢断");
		stealFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		stealFieldlbl.setBounds(425, 342, 150, 34);
		add(stealFieldlbl);
		
		JLabel blockFieldlbl = new JLabel("场均盖帽");
		blockFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		blockFieldlbl.setBounds(425, 376, 150, 34);
		add(blockFieldlbl);
		
		JLabel turnoverlbl = new JLabel("失误");
		turnoverlbl.setHorizontalAlignment(SwingConstants.CENTER);
		turnoverlbl.setBounds(425, 410, 150, 34);
		add(turnoverlbl);
		
		JLabel foullbl = new JLabel("犯规");
		foullbl.setHorizontalAlignment(SwingConstants.CENTER);
		foullbl.setBounds(425, 444, 150, 34);
		add(foullbl);
		
		JLabel lblNewLabel = new JLabel("playerGameNum");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 75, 300, 24);
		add(lblNewLabel);
		
		JLabel lblAvegamenum = new JLabel("aveGameNum");
		lblAvegamenum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvegamenum.setBounds(575, 75, 300, 24);
		add(lblAvegamenum);
		
		JLabel lblPlayerminute = new JLabel("playerMinute");
		lblPlayerminute.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerminute.setBounds(125, 109, 300, 24);
		add(lblPlayerminute);
		
		JLabel lblPlayerscorefield = new JLabel("playerScoreField");
		lblPlayerscorefield.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerscorefield.setBounds(125, 143, 300, 24);
		add(lblPlayerscorefield);
		
		JLabel lblPlayerassistancefield = new JLabel("playerAssistanceField");
		lblPlayerassistancefield.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerassistancefield.setBounds(125, 177, 300, 24);
		add(lblPlayerassistancefield);
		
		JLabel lblPlayerreboundfield = new JLabel("playerReboundField");
		lblPlayerreboundfield.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerreboundfield.setBounds(125, 211, 300, 24);
		add(lblPlayerreboundfield);
		
		JLabel lblPlayerhitnum = new JLabel("playerHitNum");
		lblPlayerhitnum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerhitnum.setBounds(125, 245, 300, 24);
		add(lblPlayerhitnum);
		
		JLabel lblPlayerprate = new JLabel("player3PRate");
		lblPlayerprate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerprate.setBounds(125, 279, 300, 24);
		add(lblPlayerprate);
		
		JLabel lblPlayerfreethrowrate = new JLabel("playerFreeThrowRate");
		lblPlayerfreethrowrate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerfreethrowrate.setBounds(125, 313, 300, 24);
		add(lblPlayerfreethrowrate);
		
		JLabel lblPlayersteal = new JLabel("playerSteal");
		lblPlayersteal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayersteal.setBounds(125, 347, 300, 24);
		add(lblPlayersteal);
		
		JLabel lblPlayerblock = new JLabel("playerBlock");
		lblPlayerblock.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerblock.setBounds(125, 381, 300, 24);
		add(lblPlayerblock);
		
		JLabel lblPlayerturnover = new JLabel("playerTurnOver");
		lblPlayerturnover.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerturnover.setBounds(125, 415, 300, 24);
		add(lblPlayerturnover);
		
		JLabel lblPlayerfoul = new JLabel("playerFoul");
		lblPlayerfoul.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerfoul.setBounds(125, 449, 300, 24);
		add(lblPlayerfoul);
		
		JLabel lblAveminute = new JLabel("aveMinute");
		lblAveminute.setHorizontalAlignment(SwingConstants.CENTER);
		lblAveminute.setBounds(575, 109, 300, 24);
		add(lblAveminute);
		
		JLabel lblAvescorefield = new JLabel("aveScoreField");
		lblAvescorefield.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvescorefield.setBounds(575, 143, 300, 24);
		add(lblAvescorefield);
		
		JLabel lblAveassistancefield = new JLabel("aveAssistanceField");
		lblAveassistancefield.setHorizontalAlignment(SwingConstants.CENTER);
		lblAveassistancefield.setBounds(575, 177, 300, 24);
		add(lblAveassistancefield);
		
		JLabel lblAvereboundfield = new JLabel("aveReboundField");
		lblAvereboundfield.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvereboundfield.setBounds(575, 211, 300, 24);
		add(lblAvereboundfield);
		
		JLabel lblAvehitnum = new JLabel("aveHitNum");
		lblAvehitnum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvehitnum.setBounds(575, 245, 300, 24);
		add(lblAvehitnum);
		
		JLabel lblAve3prate = new JLabel("ave3PRate");
		lblAve3prate.setHorizontalAlignment(SwingConstants.CENTER);
		lblAve3prate.setBounds(575, 279, 300, 24);
		add(lblAve3prate);
		
		JLabel lblAvefreethrowrate = new JLabel("aveFreeThrowRate");
		lblAvefreethrowrate.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvefreethrowrate.setBounds(585, 313, 300, 24);
		add(lblAvefreethrowrate);
		
		JLabel lblAvesteal = new JLabel("aveSteal");
		lblAvesteal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvesteal.setBounds(575, 347, 300, 24);
		add(lblAvesteal);
		
		JLabel lblAveblock = new JLabel("aveBlock");
		lblAveblock.setHorizontalAlignment(SwingConstants.CENTER);
		lblAveblock.setBounds(575, 381, 300, 24);
		add(lblAveblock);
		
		JLabel lblAveturnover = new JLabel("aveTurnOver");
		lblAveturnover.setHorizontalAlignment(SwingConstants.CENTER);
		lblAveturnover.setBounds(575, 415, 300, 24);
		add(lblAveturnover);
		
		JLabel lblAvefoul = new JLabel("aveFoul");
		lblAvefoul.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvefoul.setBounds(575, 449, 300, 24);
		add(lblAvefoul);
		
		txtPgamenum = new JTextField();
		txtPgamenum.setText("pGameNum");
		txtPgamenum.setHorizontalAlignment(SwingConstants.CENTER);
		txtPgamenum.setBounds(30, 75, 60, 24);
		add(txtPgamenum);
		txtPgamenum.setColumns(10);
		
		txtPminute = new JTextField();
		txtPminute.setText("pMinute");
		txtPminute.setHorizontalAlignment(SwingConstants.CENTER);
		txtPminute.setColumns(10);
		txtPminute.setBounds(30, 109, 60, 24);
		add(txtPminute);
		
		txtPscorefield = new JTextField();
		txtPscorefield.setText("pScoreField");
		txtPscorefield.setHorizontalAlignment(SwingConstants.CENTER);
		txtPscorefield.setColumns(10);
		txtPscorefield.setBounds(30, 143, 60, 24);
		add(txtPscorefield);
		
		txtPassistancefield = new JTextField();
		txtPassistancefield.setText("pAssistanceField");
		txtPassistancefield.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassistancefield.setColumns(10);
		txtPassistancefield.setBounds(30, 177, 60, 24);
		add(txtPassistancefield);
		
		txtPreboundfield = new JTextField();
		txtPreboundfield.setText("pReboundField");
		txtPreboundfield.setHorizontalAlignment(SwingConstants.CENTER);
		txtPreboundfield.setColumns(10);
		txtPreboundfield.setBounds(30, 211, 60, 24);
		add(txtPreboundfield);
		
		txtPhitnum = new JTextField();
		txtPhitnum.setText("pHitNum");
		txtPhitnum.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhitnum.setColumns(10);
		txtPhitnum.setBounds(30, 245, 60, 24);
		add(txtPhitnum);
		
		txtPprate = new JTextField();
		txtPprate.setText("p3PRate");
		txtPprate.setHorizontalAlignment(SwingConstants.CENTER);
		txtPprate.setColumns(10);
		txtPprate.setBounds(30, 279, 60, 24);
		add(txtPprate);
		
		txtPfreethrowrate = new JTextField();
		txtPfreethrowrate.setText("pFreeThrowRate");
		txtPfreethrowrate.setHorizontalAlignment(SwingConstants.CENTER);
		txtPfreethrowrate.setColumns(10);
		txtPfreethrowrate.setBounds(30, 313, 60, 24);
		add(txtPfreethrowrate);
		
		txtPsteal = new JTextField();
		txtPsteal.setText("pSteal");
		txtPsteal.setHorizontalAlignment(SwingConstants.CENTER);
		txtPsteal.setColumns(10);
		txtPsteal.setBounds(30, 347, 60, 24);
		add(txtPsteal);
		
		txtPblock = new JTextField();
		txtPblock.setText("pBlock");
		txtPblock.setHorizontalAlignment(SwingConstants.CENTER);
		txtPblock.setColumns(10);
		txtPblock.setBounds(30, 381, 60, 24);
		add(txtPblock);
		
		txtPturnover = new JTextField();
		txtPturnover.setText("pTurnOver");
		txtPturnover.setHorizontalAlignment(SwingConstants.CENTER);
		txtPturnover.setColumns(10);
		txtPturnover.setBounds(30, 415, 60, 24);
		add(txtPturnover);
		
		txtPfoul = new JTextField();
		txtPfoul.setText("pFoul");
		txtPfoul.setHorizontalAlignment(SwingConstants.CENTER);
		txtPfoul.setColumns(10);
		txtPfoul.setBounds(30, 449, 60, 24);
		add(txtPfoul);
		
		txtAgamenum = new JTextField();
		txtAgamenum.setText("aGameNum");
		txtAgamenum.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgamenum.setColumns(10);
		txtAgamenum.setBounds(910, 75, 60, 24);
		add(txtAgamenum);
		
		txtAminute = new JTextField();
		txtAminute.setText("aMinute");
		txtAminute.setHorizontalAlignment(SwingConstants.CENTER);
		txtAminute.setColumns(10);
		txtAminute.setBounds(910, 109, 60, 24);
		add(txtAminute);
		
		txtAscorefield = new JTextField();
		txtAscorefield.setText("aScoreField");
		txtAscorefield.setHorizontalAlignment(SwingConstants.CENTER);
		txtAscorefield.setColumns(10);
		txtAscorefield.setBounds(910, 143, 60, 24);
		add(txtAscorefield);
		
		txtAassistancefield = new JTextField();
		txtAassistancefield.setText("aAssistanceField");
		txtAassistancefield.setHorizontalAlignment(SwingConstants.CENTER);
		txtAassistancefield.setColumns(10);
		txtAassistancefield.setBounds(910, 177, 60, 24);
		add(txtAassistancefield);
		
		txtAreboundfield = new JTextField();
		txtAreboundfield.setText("aReboundField");
		txtAreboundfield.setHorizontalAlignment(SwingConstants.CENTER);
		txtAreboundfield.setColumns(10);
		txtAreboundfield.setBounds(910, 211, 60, 24);
		add(txtAreboundfield);
		
		txtAhitnum = new JTextField();
		txtAhitnum.setText("aHitNum");
		txtAhitnum.setHorizontalAlignment(SwingConstants.CENTER);
		txtAhitnum.setColumns(10);
		txtAhitnum.setBounds(910, 245, 60, 24);
		add(txtAhitnum);
		
		txtAprate = new JTextField();
		txtAprate.setText("a3PRate");
		txtAprate.setHorizontalAlignment(SwingConstants.CENTER);
		txtAprate.setColumns(10);
		txtAprate.setBounds(910, 279, 60, 24);
		add(txtAprate);
		
		txtAfreethrowrate = new JTextField();
		txtAfreethrowrate.setText("aFreeThrowRate");
		txtAfreethrowrate.setHorizontalAlignment(SwingConstants.CENTER);
		txtAfreethrowrate.setColumns(10);
		txtAfreethrowrate.setBounds(910, 313, 60, 24);
		add(txtAfreethrowrate);
		
		txtAsteal = new JTextField();
		txtAsteal.setText("aSteal");
		txtAsteal.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsteal.setColumns(10);
		txtAsteal.setBounds(910, 347, 60, 24);
		add(txtAsteal);
		
		txtAblock = new JTextField();
		txtAblock.setText("aBlock");
		txtAblock.setHorizontalAlignment(SwingConstants.CENTER);
		txtAblock.setColumns(10);
		txtAblock.setBounds(910, 381, 60, 24);
		add(txtAblock);
		
		txtAturnover = new JTextField();
		txtAturnover.setText("aTurnOver");
		txtAturnover.setHorizontalAlignment(SwingConstants.CENTER);
		txtAturnover.setColumns(10);
		txtAturnover.setBounds(910, 415, 60, 24);
		add(txtAturnover);
		
		txtAfoul = new JTextField();
		txtAfoul.setText("aFoul");
		txtAfoul.setHorizontalAlignment(SwingConstants.CENTER);
		txtAfoul.setColumns(10);
		txtAfoul.setBounds(910, 449, 60, 24);
		add(txtAfoul);
		
	}
}
