USE [BookTrading]
GO
/****** Object:  Table [dbo].[category]    Script Date: 9/13/2021 5:49:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[categoryid] [int] NOT NULL,
	[category_name] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK__category__23CDE590D15B7D1C] PRIMARY KEY CLUSTERED 
(
	[categoryid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customer]    Script Date: 9/13/2021 5:49:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[address] [varchar](255) NULL,
	[full_name] [nvarchar](255) NULL,
	[password] [varchar](12) NULL,
	[phone_number] [int] NOT NULL,
	[username] [varchar](12) NULL,
 CONSTRAINT [PK__customer__3213E83F98C5313C] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 9/13/2021 5:49:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[bookid] [int] IDENTITY(1,1) NOT NULL,
	[actived] [bit] NOT NULL,
	[book_name] [nvarchar](255) NOT NULL,
	[image] [varchar](255) NULL,
	[cateid] [int] NULL,
 CONSTRAINT [PK__product__8BEA95C55C71291D] PRIMARY KEY CLUSTERED 
(
	[bookid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[store]    Script Date: 9/13/2021 5:49:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[store](
	[storeid] [int] IDENTITY(1,1) NOT NULL,
	[bookid] [int] NULL,
	[user_storeid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[storeid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[category] ([categoryid], [category_name]) VALUES (1, N'Trinh Thám')
INSERT [dbo].[category] ([categoryid], [category_name]) VALUES (2, N'Tình Cảm')
INSERT [dbo].[category] ([categoryid], [category_name]) VALUES (3, N'Lịch Sử')
INSERT [dbo].[category] ([categoryid], [category_name]) VALUES (4, N'Đời Sống')
GO
SET IDENTITY_INSERT [dbo].[customer] ON 

INSERT [dbo].[customer] ([id], [address], [full_name], [password], [phone_number], [username]) VALUES (1, N'TP HCM', N'Quách Diêm Phu?c', N'123456789', 963230016, N'user01')
INSERT [dbo].[customer] ([id], [address], [full_name], [password], [phone_number], [username]) VALUES (2, N'TP HCM', N'Quách Diêm Phuớc', N'123456789', 366533889, N'admin01')
INSERT [dbo].[customer] ([id], [address], [full_name], [password], [phone_number], [username]) VALUES (3, N'TP HCM', N'Quách Diêm Phuoc', N'123456789', 993216551, N'user02')
SET IDENTITY_INSERT [dbo].[customer] OFF
GO
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([bookid], [actived], [book_name], [image], [cateid]) VALUES (3, 1, N'Thám Tử Sherlock Holmes', N'ThamTuSherlockHolmes.jpg', 1)
INSERT [dbo].[product] ([bookid], [actived], [book_name], [image], [cateid]) VALUES (4, 1, N'Tìm Kiếm SteveJob', N'TimKiemSteveJob.jpg', 1)
INSERT [dbo].[product] ([bookid], [actived], [book_name], [image], [cateid]) VALUES (5, 1, N'Cánh Cửa Mở Rộng', N'CanhCuaMoRong.jpg', 2)
INSERT [dbo].[product] ([bookid], [actived], [book_name], [image], [cateid]) VALUES (6, 1, N'Duyên Trời Định', N'DuyenTroiDinh.jpg', 2)
INSERT [dbo].[product] ([bookid], [actived], [book_name], [image], [cateid]) VALUES (7, 1, N'Số Ít Được Chọn', N'SoItDuocLuaChon.jpg', 3)
INSERT [dbo].[product] ([bookid], [actived], [book_name], [image], [cateid]) VALUES (8, 1, N'Rừng Na Uy', N'RungNauy.jpg', 3)
INSERT [dbo].[product] ([bookid], [actived], [book_name], [image], [cateid]) VALUES (9, 1, N'Con Người Toàn Diện Hạnh Phúc Toàn Diện', N'ConNguoiToanDien.jpg', 4)
INSERT [dbo].[product] ([bookid], [actived], [book_name], [image], [cateid]) VALUES (10, 1, N'Tôi Là Ai', N'ToiLaAi.jpg', 4)
SET IDENTITY_INSERT [dbo].[product] OFF
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FKt3b224xjwuefm2m3hhfxwp067] FOREIGN KEY([cateid])
REFERENCES [dbo].[category] ([categoryid])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FKt3b224xjwuefm2m3hhfxwp067]
GO
ALTER TABLE [dbo].[store]  WITH CHECK ADD  CONSTRAINT [FKeco69d6u2wbygtie4sd0ho6mj] FOREIGN KEY([user_storeid])
REFERENCES [dbo].[customer] ([id])
GO
ALTER TABLE [dbo].[store] CHECK CONSTRAINT [FKeco69d6u2wbygtie4sd0ho6mj]
GO
ALTER TABLE [dbo].[store]  WITH CHECK ADD  CONSTRAINT [FKke512g4we8viefu2eu85nl59x] FOREIGN KEY([bookid])
REFERENCES [dbo].[store] ([storeid])
GO
ALTER TABLE [dbo].[store] CHECK CONSTRAINT [FKke512g4we8viefu2eu85nl59x]
GO
