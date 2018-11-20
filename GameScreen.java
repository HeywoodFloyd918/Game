package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;


public class GameScreen implements Screen {

	final MyGdxGame game;


	Texture ipause;
	Rectangle pause;



	float temp;
	int temp_money;

	double hardcore2;
	double hardcore;
	double spawn_enemy;


	Music worker_sound;
	Music legend_sound;
	Music slave_sound;
	Music noob_sound;
	Music enemy_sound;



	Rectangle upgrade1;

	Texture iupgrade;

	Texture ihelp;
	Rectangle help;


	ArrayList<Noob> del_noobs;
	ArrayList<Noob> noobs;
	ArrayList<Slave> del_slaves;
	ArrayList<Arrow> del_arrows;
	ArrayList<Enemy1> enemyis1;
	ArrayList<Enemy1> del_enemyis1;
	Array<Worker> workers;
	Texture itrap;
	ArrayList<Legend> legends;
	ArrayList<Legend> del_legends;
	ArrayList<Slave> slaves;
	SpriteBatch batch;
	Texture irestart;
	Texture ith;
	Texture ihouse1;
	Texture ihouse2;
	Texture ihouse3;
	Texture ifarm1;
	Texture ifarm2;
	Texture ifarm3;

	Rectangle restart;
	Rectangle house1;
	Rectangle house2;
	Rectangle house3;
	Rectangle background;
	Texture ifireball;
	Texture inoob;
	Texture islave;
	Texture iworker;
	Texture ilegend;
	Texture ienemy;
	Texture ibackground;
	Rectangle gold;
	Rectangle trap;
	Texture igold;
    Rectangle th;
	Vector3 pos;
	BitmapFont r1;



	float newx;
	float newy;

	OrthographicCamera camera;



	public GameScreen(final MyGdxGame gam) {

		this.game = gam;



		game.playlist_index = 0;


        ihelp = new Texture (Gdx.files.internal("help.png"));
        help = new Rectangle(520,390,100,100);



		ifarm1 = new Texture(Gdx.files.internal("house1.png"));
		ifarm2 = new Texture(Gdx.files.internal("house2.png"));
		ifarm3 = new Texture(Gdx.files.internal("house3.png"));





        ipause = new Texture(Gdx.files.internal("p.png"));
        pause = new Rectangle(600,390,100,100);

		irestart = new Texture(Gdx.files.internal("r.png"));
		restart = new Rectangle(680,390,100,100);

		game.money=300;
		game.delta_fire=0;
		game.delta_hp=0;
		game.delta_price=0;
		game.delta_velocity=0;

		game.point =0;

		game.up_velocity=0;
		game.up_hp=0;
		game.up_price=0;
		game.up_fire=0;
		game.up_global=0;

		game.down_velocity=1;
		game.down_hp=1;
		game.down_price=1;
		game.down_fire=1;

		hardcore2 = TimeUtils.millis();
		hardcore = 100;
		spawn_enemy =TimeUtils.millis();


		iupgrade = new Texture(Gdx.files.internal("up.png"));
		upgrade1 = new Rectangle(680,60,60,100);






		worker_sound = Gdx.audio.newMusic(Gdx.files.internal("music5.mp3"));
		legend_sound = Gdx.audio.newMusic(Gdx.files.internal("music2.mp3"));
		slave_sound = Gdx.audio.newMusic(Gdx.files.internal("music4.mp3"));
		noob_sound = Gdx.audio.newMusic(Gdx.files.internal("music3.mp3"));
		enemy_sound = Gdx.audio.newMusic(Gdx.files.internal("music6.mp3"));

		game.money=350;

		Legend.shp=120;
		Worker.svelocity_worker=50;


		del_noobs = new ArrayList<Noob>();
		noobs = new ArrayList<Noob>();

		del_slaves = new ArrayList<Slave>() ;
		del_arrows = new ArrayList<Arrow> ();
		enemyis1 = new ArrayList<Enemy1>();
		del_enemyis1 = new ArrayList<Enemy1>();
		r1 = new BitmapFont();


		slaves = new ArrayList<Slave>();
		legends = new ArrayList<Legend>();
		del_legends = new ArrayList<Legend>();
        workers = new Array<Worker>();


		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		//
		ith= new Texture(Gdx.files.internal("44.png"));
		ienemy = new Texture(Gdx.files.internal("Orc1.png"));
		itrap = new Texture(Gdx.files.internal("44.png"));

		igold= new Texture (Gdx.files.internal("5.png"));

		inoob = new Texture(Gdx.files.internal("Farmer.png"));
		iworker = new Texture(Gdx.files.internal("23.png"));
		islave = new Texture(Gdx.files.internal("w.png"));
		ifireball = new Texture(Gdx.files.internal("4444.png"));
		ilegend = new Texture(Gdx.files.internal("1234.png"));
		ihouse1 = new Texture(Gdx.files.internal("55.png"));

		ihouse2 = new Texture(Gdx.files.internal("33.png"));

		ihouse3 = new Texture(Gdx.files.internal("22.png"));
		ibackground = new Texture(Gdx.files.internal("backgroundimage.png"));
        background = new Rectangle(0,0,800,480);



		th = new Rectangle(30,80,10,10);

		gold = new Rectangle(10,370,100,100);




		house2 = new Rectangle();
		house2.height = 115;
		house2.width=115;
		house2.x = 180;
		house2.y = 180;

		pos = new Vector3();

		house3 = new Rectangle();
		house3.height = 115;
		house3.width=115;
		house3.x = 180;
		house3.y = 300;

		house1 = new Rectangle();
		house1.height = 115;
		house1.width=115;
		house1.x = 180;
		house1.y = 60;


		trap = new Rectangle();
		trap.height = 115;
		trap.width = 115;
		trap.x = 0;
		trap.y = 50;
        newx = pos.x;
				newy = pos.y;


         Worker i = new Worker();
         workers.add(i);
	}





	public void Enemy_spawn()
	{
		Enemy1 temp = new Enemy1();
		enemyis1.add(temp);
	}


	public void Click() {

		pos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(pos);




		if ((pos.x < 150) && (pos.y < 150)) {
			{

				if (game.money >= Worker.price*workers.size) {
					game.money -= Worker.price*workers.size;
					Worker_Spawn();
					worker_sound.play();

				}

			}
		} else if ((pos.x > 180) && (pos.y > 200) && (pos.y < 340)) {

			{
				if (game.money >= Slave.price) {
					game.money -= Slave.price;
					Slave_Spawn();
					slave_sound.play();
				}


			}
		} else if ((pos.x > 180) && (pos.y < 460) && (pos.y > 320 && pos.x < 290)) {
			{
				if (game.money >= Legend.price) {
					game.money -= Legend.price;
					Legend_Spawn();
					legend_sound.play();
				}


			}

		} else if ((pos.x > 180) && (pos.y > 80) && (pos.y < 220)&& (pos.x < 320) && (TimeUtils.nanoTime() - game.last_time5 > 190000000)) {
			{
				if (game.money >= Noob.price) {
					game.money -= Noob.price;
					Noob_Spawn();
					noob_sound.play();
					//

					//

				}


			}


		} else if ((pos.x > 670) && (pos.y < 180) && (pos.y > 40) && (pos.x < 800)) {
			game.last_time2 = TimeUtils.nanoTime();
			//this.pause();
			game.setScreen(new UpgradeScreen(game, this));
			game.playlist.get(game.playlist_index).pause();

		}
		else if ((pos.x > 680) && (pos.y > 390) && (pos.y < 480)) {
			{
				game.playlist.get(game.playlist_index).stop();
				game.playlist_index=-1;
				game.setScreen(new GameScreen(game));
				dispose();



			}
		}
		else if ((pos.x > 600) && (pos.y < 480) && (pos.y > 390) && (pos.x < 680)) {
			game.last_time3 = TimeUtils.nanoTime();
			game.setScreen(new PauseScreen(game, this));
			game.playlist.get(game.playlist_index).pause();
		}

		else if ((pos.x > 520) && (pos.y > 400) && (pos.y < 500)&&(pos.x < 600) ) {
			game.setScreen(new PriceScreen(game, this));
			game.last_time6 = TimeUtils.nanoTime();
			game.playlist.get(game.playlist_index).pause();

		}
	}







	public void Worker_Spawn()
	{
		Worker temp = new Worker();
		workers.add(temp);
		game.last_time = TimeUtils.nanoTime();
	}

	public void Legend_Spawn()
	{
		Legend temp = new Legend();
		legends.add(temp);
		game.last_time = TimeUtils.nanoTime();

	}

	public void Slave_Spawn()
	{

		Slave temp = new Slave(game.delta_fire);
		slaves.add(temp);
		game.last_time = TimeUtils.nanoTime();
	}

	public void Noob_Spawn()
	{
		Noob temp = new Noob();
		noobs.add(temp);
		game.last_time = TimeUtils.nanoTime();

	}



	@Override
	public void show() {
		game.playlist.get(game.playlist_index).play();
        this.resume();
	}

	@Override
	public void render(float delta) {


		Gdx.gl.glClearColor(0, 1, 1, 1);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);





		if (game.playlist_index==-1) {
			game.playlist_index++;
			game.playlist.get(game.playlist_index).play();
		}
		if (!game.playlist.get(game.playlist_index).isPlaying()&& game.game_complete==false) {
			game.playlist_index++;

			if (game.playlist_index<4)
			game.playlist.get(game.playlist_index).play();
			else{
				game.setScreen(new GameWinScreen(game,this));

			}
		}
		if (game.game_complete == true && !game.playlist.get(game.playlist_index).isPlaying())
		{
			game.playlist_index++;

			if (game.playlist_index<4)
				game.playlist.get(game.playlist_index).play();
			else{
				game.playlist_index = 0;
				game.playlist.get(game.playlist_index).play();
			}
		}




		game.batch.begin();


		game.batch.draw(ibackground, background.x,background.y,background.width,background.height);
		game.font1.draw(game.batch, "Money: " + game.money, 110, 460);
		game.font1.draw(game.batch, "Point: " + game.point, 210, 460);
		game.font1.draw(game.batch, "High score: " + game.record, 280, 460);
		game.font1.draw(game.batch,"Price of worker: "+Worker.price*workers.size ,10,35);
		if (legends.size()>0)
		game.font1.draw(game.batch, Integer.toString(legends.get(0).hp) ,400,35);

		game.batch.draw(ihelp, help.x,help.y, help.getHeight(), help.getWidth());
		game.batch.draw(itrap, trap.x, trap.y, trap.height, trap.width);
		game.batch.draw(igold, gold.x, gold.y, gold.height, gold.width);
		game.batch.draw(ihouse2, house2.x, house2.y, house2.height, house2.width);
		game.batch.draw(ihouse3, house3.x, house3.y, house3.height, house3.width);
		game.batch.draw(ihouse1, house1.x, house1.y, house1.height, house1.width);
        game.batch.draw(iupgrade, upgrade1.x,upgrade1.y, upgrade1.width,upgrade1.height);
        game.batch.draw(irestart, restart.x,restart.y,restart.width,restart.height);
		game.batch.draw(ipause, pause.x,pause.y,pause.width,pause.height);



		pos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(pos);





		if (enemyis1.size() != 0) {
			for (Enemy1 item : enemyis1) {
				game.batch.draw(ienemy, item.temp.getX(), item.temp.getY(), item.temp.getHeight(), item.temp.getWidth());
				item.temp.x -= item.velocity_enemy * Gdx.graphics.getDeltaTime();
				if (item.temp.getX()<130) {

					if (game.point > game.record) {
						game.record = game.point;
						game.pref.putInteger("record", game.record);
						game.pref.flush();
					}
					game.playlist.get(game.playlist_index).pause();
					game.setScreen(new GameOverScreen(game));
				}
			}


            for (Enemy1 item : del_enemyis1)
			{
				enemyis1.remove(item);
			}


		}



		if (slaves.size() > 0){
			for (Slave item : slaves) {
				if (item.arrows.size() != 0)
				{
					if (item.arrows.get(0).temp.getY() >= 380)
						item.arrows.get(0).temp.setY(380);

					if (item.arrows.get(0).temp.getY() <= 100)
						item.arrows.get(0).temp.setY(100);

					if (item.arrows.get(0).temp.getX() >= 700)
						item.arrows.get(0).temp.setX(700);

					if (item.arrows.get(0).temp.getX() <= 100)
						item.arrows.get(0).temp.setX(100);

					game.batch.draw(islave, item.temp.getX(), item.temp.getY(), item.temp.getHeight(), item.temp.getWidth());
					game.batch.draw(ifireball, item.arrows.get(0).temp.getX(), item.arrows.get(0).temp.getY(), item.arrows.get(0).temp.getHeight(), item.arrows.get(0).temp.getWidth());


					if (enemyis1.size() != 0)

					{
						if (item.arrows.get(0).enemy_number == -1)
							item.arrows.get(0).enemy_number = 0;


						if (item.arrows.get(0).enemy_number < enemyis1.size()) {
							if (item.arrows.get(0).temp.getX() < enemyis1.get(item.arrows.get(0).enemy_number).temp.getX())
								item.arrows.get(0).temp.x += item.arrows.get(0).velocity * Gdx.graphics.getDeltaTime();

							if (item.arrows.get(0).temp.getX() > enemyis1.get(item.arrows.get(0).enemy_number).temp.getX())
								item.arrows.get(0).temp.x -= item.arrows.get(0).velocity * Gdx.graphics.getDeltaTime();

							if (item.arrows.get(0).temp.getY() > enemyis1.get(item.arrows.get(0).enemy_number).temp.getY())
								item.arrows.get(0).temp.y -= item.arrows.get(0).velocity * Gdx.graphics.getDeltaTime();

							if (item.arrows.get(0).temp.getY() < enemyis1.get(item.arrows.get(0).enemy_number).temp.getY())
								item.arrows.get(0).temp.y += item.arrows.get(0).velocity * Gdx.graphics.getDeltaTime();

							///
							if (enemyis1.size()>0);
								if (item.arrows.get(0).temp.overlaps(enemyis1.get(item.arrows.get(0).enemy_number).temp)) {
									enemyis1.get(item.arrows.get(0).enemy_number).hp -= item.arrows.get(0).power;

									if (enemyis1.get(item.arrows.get(0).enemy_number).hp <= 0) {

										/*
										if (enemyis1.get(item.arrows.get(0).enemy_number).bag.size()>0)
										{
											for (int i = 0; i< enemyis1.get(item.arrows.get(0).enemy_number).bag.size(); i++)
											{
												int value;
												value = enemyis1.get(item.arrows.get(0).enemy_number).bag.get(i);
												legends.get(value).enemy_number--;
												count++;
											}

										}
										*/
										del_enemyis1.add(enemyis1.get(item.arrows.get(0).enemy_number));
										game.point++;
										enemy_sound.play();
									}
									item.arrows.remove(item.arrows.get(0));

								}


						}
						else
							item.arrows.get(0).enemy_number = 0;

					}
				}
				if (item.arrows.size() == 0)
				{
					del_slaves.add(item);
				}
			}

			for (Slave item: del_slaves)
			{
				slaves.remove(item);
			}

		}




		if (legends.size() != 0 ) {
			for (Legend item : legends) {
				if (item.temp.getY() >= 380)
					item.temp.setY(380);

				if (item.temp.getY() <= 100)
					item.temp.setY(100);

				if (item.temp.getX() >= 700)
					item.temp.setX(700);

				if (item.temp.getX() <= 100)
					item.temp.setX(100);


					/*
					for (int i = 0; i< enemyis1.size()-1; i++) {
						if (item.temp.overlaps(enemyis1.get(i).temp)) {

							if (item.hp >=40) {
								item.hp -= enemyis1.get(i).power;
								enemyis1.get(i).hp = 0;
							}
							else
							{
								item.hp = 0;
							}

							if (item.hp <=0) {
								del_legends.add(item);
							}
							if (enemyis1.get(i).hp <=0) {
								del_enemyis1.add(enemyis1.get(i));
							}

						}
					}
                  */

				game.batch.draw(ilegend, item.temp.getX(), item.temp.getY(), item.temp.getHeight(), item.temp.getWidth());


				if (enemyis1.size() != 0)

				{
					if (item.enemy_number == -1) {
						item.enemy_number =0 ;
					}
					/*
					if (item.enemy_number>0)
					{
						item.enemy_number = item.enemy_number - count;
					}
					*/
					if (enemyis1.size()>0)
						if (item.enemy_number<enemyis1.size() ) {
							if (item.temp.overlaps(enemyis1.get(item.enemy_number).temp)) {
								if (item.hp >= 40) {
									item.hp -= enemyis1.get(item.enemy_number).power;
									enemyis1.get(item.enemy_number).hp -= item.power;
								} else {
									item.hp = 0;
								}

								if (item.hp <= 0) {
									del_legends.add(item);
                              /*
								for (int i = 0; i<enemyis1.size(); i++) {
									if (enemyis1.get(i).bag.size()>0)
									for (int j = 0; j < enemyis1.get(i).bag.size(); j++)
										if (enemyis1.get(i).bag.get(j) == legends.indexOf(item))
											for (Integer item2 : enemyis1.get(i).bag) {
												item2--;
											}
								}
								*/
								}
								if (enemyis1.get(item.enemy_number).hp <= 0) {

									/*
									if (enemyis1.get(item.enemy_number).bag.size() > 0) {
										for (int i = 0; i < enemyis1.get(item.enemy_number).bag.size(); i++) {
											int value;
											value = enemyis1.get(item.enemy_number).bag.get(i);
											legends.get(value).enemy_number--;
											count++;
										}
										item.enemy_number = -1;

									}
									*/
									game.point++;
									del_enemyis1.add(enemyis1.get(item.enemy_number));
									enemy_sound.play();
								}
							}
						}
						else
							item.enemy_number =0 ;





					if (item.enemy_number < enemyis1.size() || enemyis1.size()>0) {
						if (item.temp.getX() < enemyis1.get(item.enemy_number).temp.getX()) {
							item.temp.x += item.velocity * Gdx.graphics.getDeltaTime();

						}


						if (item.temp.getX() > enemyis1.get(item.enemy_number).temp.getX()) {

							//int old_enemy_number = item.enemy_number;

							for (int i = 0; i < enemyis1.size() ; i++) {
								if (!(item.temp.getX() > enemyis1.get(i).temp.getX())) {
									item.enemy_number = i;
									break;
								}

							}
							if (item.enemy_number == 0 )
								item.temp.x -= item.velocity * Gdx.graphics.getDeltaTime();
							//else enemyis1.get(old_enemy_number).bag.add(legends.indexOf(item));

						}


						if (item.temp.getY() < enemyis1.get(item.enemy_number).temp.getY())
							item.temp.y += item.velocity * Gdx.graphics.getDeltaTime();

						if (item.temp.getY()> enemyis1.get(item.enemy_number).temp.getY())
							item.temp.y -= item.velocity * Gdx.graphics.getDeltaTime();
						;

						///

///

					}
					else
					{
						item.enemy_number = 0;
					}
				}

			}
			for (Legend item: del_legends)
			{
				legends.remove(item);
			}
		}

		if (workers.size != 0) {

			for (Worker item : workers) {

				game.batch.draw(iworker, item.temp.getX(), item.temp.getY(), item.temp.getHeight(), item.temp.getWidth());

				if (item.temp.getY() <= 90) {
					item.temp.setY(90);
					item.velocity_worker = -item.velocity_worker;
				game.money += 50;
				}
				if (item.temp.getY()>=370)
					item.velocity_worker = -item.velocity_worker;

				temp = item.temp.getY();
				temp_money = game.money;
				item.temp.y += item.velocity_worker * Gdx.graphics.getDeltaTime();

				if (item.temp.getY() == temp)
				{
					item.temp.y += item.velocity_worker * Gdx.graphics.getDeltaTime();
					game.money=temp_money;
				}



			}
		}


		if (noobs.size() != 0 ) {
			for (Noob item : noobs) {
				if (item.temp.getY() >= 380)
					item.temp.setY(380);

				if (item.temp.getY() <= 100)
					item.temp.setY(100);

				if (item.temp.getX() >= 700)
					item.temp.setX(700);

				if (item.temp.getX() <= 100)
					item.temp.setX(100);

				game.batch.draw(inoob, item.temp.getX(), item.temp.getY(), item.temp.getHeight(), item.temp.getWidth());


				if (enemyis1.size() != 0)

				{
					if (item.enemy_number == -1) {
						item.enemy_number =0 ;
					}


					if (item.enemy_number < enemyis1.size()) {
						if (item.temp.getX() < enemyis1.get(item.enemy_number).temp.getX()) {
							item.temp.x += item.velocity * Gdx.graphics.getDeltaTime();
						}
						if (item.temp.getX() > enemyis1.get(item.enemy_number).temp.getX())
							item.temp.x -= item.velocity * Gdx.graphics.getDeltaTime();

						if (item.temp.getY() < enemyis1.get(item.enemy_number).temp.getY())
							item.temp.y += item.velocity * Gdx.graphics.getDeltaTime();

						if (item.temp.getY() > enemyis1.get(item.enemy_number).temp.getY())
							item.temp.y -= item.velocity * Gdx.graphics.getDeltaTime();
						;

						///


						if (item.temp.overlaps(enemyis1.get(item.enemy_number).temp)) {

							while (enemyis1.get(item.enemy_number).hp > 0 && item.hp > 0) {
								enemyis1.get(item.enemy_number).hp -= item.power;
								item.hp -= enemyis1.get(item.enemy_number).power;
							}
							if (enemyis1.get(item.enemy_number).hp <= 0) {
								/*
								if (enemyis1.get(item.enemy_number).bag.size()>0)
								{
									for (int i = 0; i< enemyis1.get(item.enemy_number).bag.size(); i++)
									{
										int value;
										value = enemyis1.get(item.enemy_number).bag.get(i);
										legends.get(value).enemy_number--;
									}
item.enemy_number = -1;
								}
								*/
								del_enemyis1.add(enemyis1.get(item.enemy_number));
								game.point++;
								enemy_sound.play();

							}
							if (item.hp <= 0)
								del_noobs.add(item);

						}
///

					}
					else
					{
						item.enemy_number = 0;
					}
				}

			}
			for (Noob item: del_noobs)
			{
				noobs.remove(item);
			}
		}



		for (Legend item :legends)
			item.set_hp(game.delta_hp);

		game.delta_hp=0;

		for (Noob item :noobs)
			item.set_price(game.delta_price);

		game.delta_price = 0;

		for (Worker item :workers)
			item.set_velocity(game.delta_velocity);

		game.delta_velocity = 0;



		game. batch.end();



		if (Gdx.input.isTouched()) {
			if (TimeUtils.nanoTime() - game.last_time > 1000000000)
				Click();

		}

		if (TimeUtils.millis()-hardcore2 > 4000)
		{

				hardcore += 65;
				hardcore2 = TimeUtils.millis();

		}



		if (TimeUtils.millis() - spawn_enemy + hardcore >4500  ) {
			Enemy_spawn();
		    spawn_enemy = TimeUtils.millis();
		}


	}


	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

    game.playlist.get(game.playlist_index).pause();
	}

	@Override
	public void resume() {
		game.playlist.get(game.playlist_index).play();
	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {

	}
}
